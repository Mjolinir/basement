package net.kurse.basement.datagen;

import net.kurse.basement.Basement;
import net.kurse.basement.item.ModItems;
import net.kurse.basement.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Basement.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.SWORDS)
                .add(ModItems.URU_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.URU_HAMMER.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.URU_HAMMER.get());
        tag(ItemTags.AXES)
                .add(ModItems.URU_HAMMER.get());
        tag(ItemTags.HOES)
                .add(ModItems.URU_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.URU_HELMET.get())
                .add(ModItems.URU_CHESTPLATE.get())
                .add(ModItems.URU_LEGGINGS.get())
                .add(ModItems.URU_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.URU.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KURSE_SMITHING_TEMPLATE.get());
    }

}
