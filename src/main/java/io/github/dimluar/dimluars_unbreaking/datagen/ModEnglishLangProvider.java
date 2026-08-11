package io.github.dimluar.dimluars_unbreaking.datagen;

import io.github.dimluar.dimluars_unbreaking.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us" ,registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.STONE_UPGRADE_SMITHING_TEMPLATE, "Stone Upgrade");
        translationBuilder.add(ModItems.COPPER_UPGRADE_SMITHING_TEMPLATE, "Copper Upgrade");
        translationBuilder.add(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE, "Iron Upgrade");
        translationBuilder.add(ModItems.GOLD_UPGRADE_SMITHING_TEMPLATE, "Gold Upgrade");
        translationBuilder.add(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, "Diamond Upgrade");
    }
}
