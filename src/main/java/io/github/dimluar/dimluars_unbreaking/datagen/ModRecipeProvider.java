package io.github.dimluar.dimluars_unbreaking.datagen;

import io.github.dimluar.dimluars_unbreaking.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

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
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
