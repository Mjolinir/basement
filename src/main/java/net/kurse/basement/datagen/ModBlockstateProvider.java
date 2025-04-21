package net.kurse.basement.datagen;

import net.kurse.basement.Basement;
import net.kurse.basement.block.ModBlocks;
import net.kurse.basement.block.custom.UruLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Basement.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.URU_BLOCK);
        blockWithItem(ModBlocks.RAW_URU_BLOCK);

        blockWithItem(ModBlocks.URU_ORE);
        blockWithItem(ModBlocks.URU_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.URU_END_ORE);
        blockWithItem(ModBlocks.URU_NETHER_ORE);

        acustomLamp();
    }

    private void acustomLamp() {
        getVariantBuilder(ModBlocks.URU_LAMP.get()).forAllStates(state -> {
            if(state.getValue(UruLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("uru_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Basement.MOD_ID, "block/" + "uru_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("uru_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Basement.MOD_ID, "block/" + "uru_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.URU_LAMP.get(), models().cubeAll("uru_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Basement.MOD_ID, "block/" + "uru_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("basement:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("basement:block/" + deferredBlock.getId().getPath() + appendix));
    }
}

