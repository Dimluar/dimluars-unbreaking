package io.github.dimluar.dimluars_unbreaking.mixin;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ArmorMaterial.class)
public class ArmorMaterialMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    public void modifyDefense(int durability, Map<ArmorType, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, TagKey<Item> repairIngredient, ResourceKey<EquipmentAsset> assetId, CallbackInfo ci) {
        int gold_durability = 7;
        if (durability == gold_durability) {
            defense.put(ArmorType.HELMET, 3);
            defense.put(ArmorType.CHESTPLATE, 7);
            defense.put(ArmorType.LEGGINGS, 5);
            defense.put(ArmorType.BOOTS, 2);
        }
    }
}
