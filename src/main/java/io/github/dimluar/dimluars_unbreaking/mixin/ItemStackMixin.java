package io.github.dimluar.dimluars_unbreaking.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Shadow
	public abstract <T> T set(DataComponentType<T> type, @Nullable T value);

	@Inject(method = "setDamageValue", at = @At("TAIL"), cancellable = true)
	public void setDamageValue(final int value, final CallbackInfo ci) {
		this.set(DataComponents.DAMAGE, 0);
		ci.cancel();
	}
}