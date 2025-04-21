package net.kurse.basement.datagen;

import net.kurse.basement.Basement;
import net.kurse.basement.block.ModBlocks;
import net.kurse.basement.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> URU_SMELTABLES = List.of(ModItems.RAW_URU, ModBlocks.URU_ORE, ModBlocks.URU_DEEPSLATE_ORE, ModBlocks.URU_NETHER_ORE, ModBlocks.URU_END_ORE);
        List<ItemLike> URU_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_URU_BLOCK);


//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.URU_BLOCK.get())
//                .pattern("BBB")
//                .pattern("BBB")
//                .pattern("BBB")
//                .define('B', ModItems.URU.get())
//                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_URU_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_URU.get())
                .unlockedBy("has_raw_uru", has(ModItems.RAW_URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.URU_LAMP.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.REDSTONE_TORCH)
                .define('B', ModItems.URU.get())
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.URU_HAMMER.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern(" B ")
                .define('A', ModBlocks.URU_BLOCK.get())
                .define('B', Items.STICK)
                .define('C', Items.NETHER_STAR)
                .unlockedBy("has_uru_block", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.URU_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.URU.get())
                .define('B', Items.STICK)
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.URU_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.URU.get())
                .define('B', Items.STICK)
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.URU_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.URU.get())
                .define('B', Items.STICK)
                .unlockedBy("has_auru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.URU_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.URU.get())
                .define('B', Items.STICK)
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.URU_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.URU.get())
                .define('B', Items.STICK)
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.URU_BOW.get())
                .pattern(" AB")
                .pattern("C B")
                .pattern(" AB")
                .define('A', ModItems.URU.get())
                .define('B', Items.STRING)
                .define('C', Items.NETHER_STAR)
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.URU_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.URU.get())
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.URU_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.URU.get())
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.URU_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.URU.get())
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.URU_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.URU.get())
                .unlockedBy("has_uru", has(ModItems.URU)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.URU.get(), 9)
                .requires(ModBlocks.URU_BLOCK)
                .unlockedBy("has_uru_block", has(ModBlocks.URU_BLOCK)).save(recipeOutput);


        oreSmelting(recipeOutput, URU_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.URU_BLOCK.get(), 0.25f, 200, "uru");
        oreBlasting(recipeOutput, URU_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.URU_BLOCK.get(), 0.25f, 100, "uru");
        oreSmelting(recipeOutput, URU_SMELTABLES, RecipeCategory.MISC, ModItems.URU.get(), 0.25f, 200, "uru");
        oreBlasting(recipeOutput, URU_SMELTABLES, RecipeCategory.MISC, ModItems.URU.get(), 0.25f, 100, "uru");


        trimSmithing(recipeOutput, ModItems.KURSE_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(Basement.MOD_ID, "kurse"));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Basement.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
