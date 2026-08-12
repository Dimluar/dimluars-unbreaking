package io.github.dimluar.dimluars_unbreaking.datagen;

import io.github.dimluar.dimluars_unbreaking.DimluarSUnbreaking;
import io.github.dimluar.dimluars_unbreaking.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us" ,registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE, "Stone Upgrade");
        translationBuilder.add(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE, "Copper Upgrade");
        translationBuilder.add(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE, "Iron Upgrade");
        translationBuilder.add(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE, "Gold Upgrade");
        translationBuilder.add(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, "Diamond Upgrade");

        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".template.tooltip", "Smithing Template");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".empty.tooltip", "");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".apply.tooltip", "Applies to:");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".ingredient.tooltip", "Ingredients:");

        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".wood_equipment.tooltip", " Wooden Equipment");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".stone_equipment.tooltip", " Stone Equipment");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".leather_equipment.tooltip", " Leather Equipment");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".copper_equipment.tooltip", " Copper Equipment");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".iron_equipment.tooltip", " Iron Equipment");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".gold_equipment.tooltip", " Golden Equipment");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".stone_material.tooltip", " Cobblestone Variants");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".copper_material.tooltip", " Copper Ingot");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".iron_material.tooltip", " Iron Ingot");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".gold_material.tooltip", " Gold Ingot");
        translationBuilder.add("item." + DimluarSUnbreaking.MOD_ID + ".diamond_material.tooltip", " Diamond");
    }
}
