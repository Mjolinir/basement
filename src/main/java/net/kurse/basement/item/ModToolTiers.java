package net.kurse.basement.item;

import net.kurse.basement.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier URU = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_URU_TOOL,
            1600, 6f, 5f, 20, () -> Ingredient.of(ModItems.URU));
}
