package net.kurse.basement.datagen;

import net.kurse.basement.Basement;
import net.kurse.basement.enchantment.custom.Enchantments;
import net.kurse.basement.trim.TrimMaterials;
import net.kurse.basement.trim.TrimPatterns;
import net.kurse.basement.worldgen.ModBiomeModifiers;
import net.kurse.basement.worldgen.ModConfiguredFeatures;
import net.kurse.basement.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, TrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, TrimPatterns::bootstrap)
            .add(Registries.ENCHANTMENT, Enchantments::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Basement.MOD_ID));
    }
}

