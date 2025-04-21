package net.kurse.basement.datagen;

import net.kurse.basement.block.ModBlocks;
import net.kurse.basement.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.URU_BLOCK.get());
        dropSelf(ModBlocks.RAW_URU_BLOCK.get());

        add(ModBlocks.URU_ORE.get(),
                block -> createOreDrop(ModBlocks.URU_ORE.get(), ModItems.RAW_URU.get()));
        add(ModBlocks.URU_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.URU_DEEPSLATE_ORE.get(), ModItems.RAW_URU.get(), 2, 5));
        add(ModBlocks.URU_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.URU_END_ORE.get(), ModItems.RAW_URU.get(), 3, 6));
        add(ModBlocks.URU_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.URU_NETHER_ORE.get(), ModItems.RAW_URU.get(), 4, 8));


        dropSelf(ModBlocks.URU_LAMP.get());
        
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
