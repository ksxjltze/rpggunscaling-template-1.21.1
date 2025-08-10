package com.ksxjltze.rpg.scaling.guns.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = com.vicmatskiv.pointblank.item.HurtingItem.class)
public abstract class HitScanMixin extends Item {

    public HitScanMixin(Properties properties) {
        super(properties);
    }

    private double attackDamage = 1f;

    @Inject(method = "hurtEntity", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void onHurtEntity(LivingEntity player, EntityHitResult arg1, Entity arg2, ItemStack arg3, CallbackInfoReturnable<Float> cir) {
        attackDamage = player.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @ModifyVariable(method = "hurtEntity", at = @At(value = "LOAD"), argsOnly = false, name = "adjustedDamage", order = 1100)
    public double onHurtEntityModifyAdjustedDamage(double value) {
        return value + attackDamage;
    }
}
