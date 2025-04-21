package net.kurse.basement.item;

import net.kurse.basement.Basement;
import net.kurse.basement.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Basement.MOD_ID);

    public static final Supplier<CreativeModeTab> BASEMENT_ITEMS_TAB = CREATIVE_MODE_TAB.register("basement_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.URU.get()))
                    .title(Component.translatable("creativetab.basement.basement_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.URU);
                        output.accept(ModItems.RAW_URU);
                        output.accept(ModItems.URU_HAMMER);
                        output.accept(ModItems.URU_HELMET);
                        output.accept(ModItems.URU_CHESTPLATE);
                        output.accept(ModItems.URU_LEGGINGS);
                        output.accept(ModItems.URU_BOOTS);
                        output.accept(ModItems.KURSE_SMITHING_TEMPLATE);
                        output.accept(ModItems.URU_HORSE_ARMOR);
                    }).build());

    public static final Supplier<CreativeModeTab> BASEMENT_BLOCK_TAB = CREATIVE_MODE_TAB.register("basement_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.URU_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Basement.MOD_ID, "basement_items_tab"))
                    .title(Component.translatable("creativetab.basement.basement_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.URU_BLOCK);
                        output.accept(ModBlocks.URU_ORE);
                        output.accept(ModBlocks.RAW_URU_BLOCK);
                        output.accept(ModBlocks.URU_DEEPSLATE_ORE);
                        output.accept(ModBlocks.URU_NETHER_ORE);
                        output.accept(ModBlocks.URU_END_ORE);
                        output.accept(ModBlocks.URU_LAMP);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}