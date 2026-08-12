package io.github.dimluar.dimluars_unbreaking.mixin;

import net.minecraft.world.inventory.AnvilMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilMenu.class)
public class AnvilMenuMixin {
    @Inject(method = "calculateIncreasedRepairCost", at = @At("RETURN"), cancellable = true)
    private static void calculateIncreasedRepairCost(CallbackInfoReturnable<Integer> cir) {
        int level = Math.min(20, cir.getReturnValue());
        cir.setReturnValue(level);
    }
}
