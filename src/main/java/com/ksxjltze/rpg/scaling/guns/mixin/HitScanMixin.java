package com.ksxjltze.rpg.scaling.guns.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(com.vicmatskiv.pointblank.client.ClientSystem.class)
public class HitScanMixin {

    @Inject(
            at = @At("TAIL"),
            method = "<init>()V"
    )
    private void init(CallbackInfo info) {
        System.out.println("Ten Yu is so gae!");
    }
}
