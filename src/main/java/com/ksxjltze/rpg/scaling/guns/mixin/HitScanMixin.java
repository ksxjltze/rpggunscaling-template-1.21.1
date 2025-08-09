package com.ksxjltze.rpg.scaling.guns.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = com.vicmatskiv.pointblank.item.HurtingItem.class)
public abstract class HitScanMixin extends Item {

    public HitScanMixin(Properties properties) {
        super(properties);
    }

    @Shadow
    protected float damage;

    @Inject(method = "getDamage", at = @At("RETURN"), cancellable = true)
    public void onGetDamage(CallbackInfoReturnable<Float> cir) {
        System.out.println("Ten Yu is so gae!!");

        if (cir.getReturnValue() == null)
            cir.setReturnValue(this.damage);
    }
}
