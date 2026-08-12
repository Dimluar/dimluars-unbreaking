package io.github.dimluar.dimluars_unbreaking.datagen;

import io.github.dimluar.dimluars_unbreaking.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registryLookup, @NonNull RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {

                // Templates

                shaped(RecipeCategory.MISC, ModItems.STONE_UPGRADE_SMITHING_TEMPLATE, 1)
                        .pattern("aba")
                        .pattern("aba")
                        .pattern("aaa")
                        .define('a', ItemTags.PLANKS)
                        .define('b', Items.SMOOTH_STONE)
                        .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.STONE_UPGRADE_SMITHING_TEMPLATE, 2)
                        .requires(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE)
                        .requires(ItemTags.STONE_TOOL_MATERIALS)
                        .requires(ItemTags.PLANKS)
                        .requires(ItemTags.PLANKS)
                        .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, "stone_upgrade_duplicate");

                shaped(RecipeCategory.MISC, ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE, 1)
                        .pattern("aba")
                        .pattern("aca")
                        .pattern("aaa")
                        .define('a', ItemTags.STONE_TOOL_MATERIALS)
                        .define('b', Items.COPPER_INGOT)
                        .define('c', ItemTags.COPPER)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE, 2)
                        .requires(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE)
                        .requires(Items.COPPER_INGOT)
                        .requires(ItemTags.STONE_TOOL_MATERIALS)
                        .requires(ItemTags.STONE_TOOL_MATERIALS)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, "copper_upgrade_duplicate");

                shaped(RecipeCategory.MISC, ModItems.IRON_UPGRADE_SMITHING_TEMPLATE, 1)
                        .pattern("aba")
                        .pattern("aca")
                        .pattern("aaa")
                        .define('a', Items.COPPER_INGOT)
                        .define('b', Items.IRON_INGOT)
                        .define('c', Items.IRON_BLOCK)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.IRON_UPGRADE_SMITHING_TEMPLATE, 2)
                        .requires(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE)
                        .requires(Items.IRON_INGOT)
                        .requires(Items.COPPER_INGOT, 2)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, "iron_upgrade_duplicate");

                shaped(RecipeCategory.MISC, ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE, 1)
                        .pattern("aba")
                        .pattern("aca")
                        .pattern("aaa")
                        .define('a', Items.IRON_INGOT)
                        .define('b', Items.GOLD_INGOT)
                        .define('c', Items.GOLD_BLOCK)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE, 2)
                        .requires(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE)
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.IRON_INGOT, 2)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, "gold_upgrade_duplicate");

                shaped(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 1)
                        .pattern("aba")
                        .pattern("aca")
                        .pattern("aaa")
                        .define('a', Items.GOLD_INGOT)
                        .define('b', Items.DIAMOND)
                        .define('c', Items.DIAMOND_BLOCK)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 2)
                        .requires(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE)
                        .requires(Items.DIAMOND)
                        .requires(Items.GOLD_INGOT, 2)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, "diamond_upgrade_duplicate");

                shapeless(RecipeCategory.MISC, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 2)
                        .requires(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                        .requires(Items.NETHERITE_SCRAP)
                        .requires(Items.DIAMOND, 2)
                        .unlockedBy(getHasName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output);

                // Stone Tier

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.WOODEN_PICKAXE),
                                this.tag(ItemTags.STONE_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.STONE_PICKAXE
                        ).unlocks(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, getItemName(Items.STONE_PICKAXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.WOODEN_AXE),
                                this.tag(ItemTags.STONE_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.STONE_AXE
                        ).unlocks(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, getItemName(Items.STONE_AXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.WOODEN_SHOVEL),
                                this.tag(ItemTags.STONE_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.STONE_SHOVEL
                        ).unlocks(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, getItemName(Items.STONE_SHOVEL));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.WOODEN_HOE),
                                this.tag(ItemTags.STONE_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.STONE_HOE
                        ).unlocks(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, getItemName(Items.STONE_HOE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.WOODEN_SWORD),
                                this.tag(ItemTags.STONE_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.STONE_SWORD
                        ).unlocks(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, getItemName(Items.STONE_SWORD));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.WOODEN_SPEAR),
                                this.tag(ItemTags.STONE_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.STONE_SPEAR
                        ).unlocks(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output, getItemName(Items.STONE_SPEAR));

                // Copper Tier

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.STONE_PICKAXE),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.COPPER_PICKAXE
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_PICKAXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.STONE_AXE),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.COPPER_AXE
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_AXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.STONE_SHOVEL),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.COPPER_SHOVEL
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_SHOVEL));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.STONE_HOE),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.COPPER_HOE
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_HOE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.STONE_SWORD),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_SWORD
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_SWORD));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.STONE_SPEAR),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_SPEAR
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_SPEAR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.LEATHER_HELMET),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_HELMET
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_HELMET));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.LEATHER_CHESTPLATE),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_CHESTPLATE
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_CHESTPLATE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.LEATHER_LEGGINGS),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_LEGGINGS
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_LEGGINGS));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.LEATHER_BOOTS),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_BOOTS
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_BOOTS));

                // Iron Tier

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_PICKAXE),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.IRON_PICKAXE
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_PICKAXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_AXE),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.IRON_AXE
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_AXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_SHOVEL),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.IRON_SHOVEL
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_SHOVEL));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_HOE),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.IRON_HOE
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_HOE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_SWORD),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_SWORD
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_SWORD));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_SPEAR),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_SPEAR
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_SPEAR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_HELMET),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_HELMET
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_HELMET));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_CHESTPLATE),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_CHESTPLATE
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_CHESTPLATE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_LEGGINGS),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_LEGGINGS
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_LEGGINGS));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_BOOTS),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_BOOTS
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_BOOTS));

                // Gold Tier

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_PICKAXE),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.GOLDEN_PICKAXE
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_PICKAXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_AXE),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.GOLDEN_AXE
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_AXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_SHOVEL),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.GOLDEN_SHOVEL
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_SHOVEL));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_HOE),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.GOLDEN_HOE
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_HOE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_SWORD),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_SWORD
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_SWORD));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_SPEAR),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_SPEAR
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_SPEAR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_HELMET),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_HELMET
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_HELMET));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_CHESTPLATE),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_CHESTPLATE
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_CHESTPLATE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_LEGGINGS),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_LEGGINGS
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_LEGGINGS));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_BOOTS),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_BOOTS
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_BOOTS));

                // Diamond Tier

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_PICKAXE),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.DIAMOND_PICKAXE
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_PICKAXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_AXE),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.DIAMOND_AXE
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_AXE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_SHOVEL),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.DIAMOND_SHOVEL
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_SHOVEL));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_HOE),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.TOOLS,
                                Items.DIAMOND_HOE
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_HOE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_SWORD),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_SWORD
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_SWORD));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_SPEAR),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_SPEAR
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_SPEAR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_HELMET),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_HELMET
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_HELMET));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_CHESTPLATE),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_CHESTPLATE
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_CHESTPLATE));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_LEGGINGS),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_LEGGINGS
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_LEGGINGS));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_BOOTS),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_BOOTS
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_BOOTS));

                // Animal Armors

                shaped(RecipeCategory.COMBAT, Items.COPPER_NAUTILUS_ARMOR)
                        .pattern("aa ")
                        .pattern("aa ")
                        .pattern("aaa")
                        .define('a', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output);

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.LEATHER_HORSE_ARMOR),
                                this.tag(ItemTags.COPPER_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.COPPER_HORSE_ARMOR
                        ).unlocks(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(output, getItemName(Items.COPPER_HORSE_ARMOR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_NAUTILUS_ARMOR),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_NAUTILUS_ARMOR
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_NAUTILUS_ARMOR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.COPPER_HORSE_ARMOR),
                                this.tag(ItemTags.IRON_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.IRON_HORSE_ARMOR
                        ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(output, getItemName(Items.IRON_HORSE_ARMOR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_NAUTILUS_ARMOR),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_NAUTILUS_ARMOR
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_NAUTILUS_ARMOR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.IRON_HORSE_ARMOR),
                                this.tag(ItemTags.GOLD_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.GOLDEN_HORSE_ARMOR
                        ).unlocks(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .save(output, getItemName(Items.GOLDEN_HORSE_ARMOR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_NAUTILUS_ARMOR),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_NAUTILUS_ARMOR
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_NAUTILUS_ARMOR));

                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(Items.GOLDEN_HORSE_ARMOR),
                                this.tag(ItemTags.DIAMOND_TOOL_MATERIALS),
                                RecipeCategory.COMBAT,
                                Items.DIAMOND_HORSE_ARMOR
                        ).unlocks(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output, getItemName(Items.DIAMOND_HORSE_ARMOR));

                // Smithing Table

                shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
                        .pattern("aa")
                        .pattern("bb")
                        .pattern("bb")
                        .define('a', Items.SMOOTH_STONE)
                        .define('b', ItemTags.PLANKS)
                        .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                        .save(output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "ModRecipeProvider";
    }
}
