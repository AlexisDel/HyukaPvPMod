package net.fantiks.hyukamod.client.mixin.entity;

import net.fantiks.hyukamod.behavior.OldAnimationsLivingEntityBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin{

    @Shadow public abstract ItemStack getActiveItem();

    // Knockback in air
    @Redirect(method = "takeKnockback", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;onGround:Z", opcode = Opcodes.GETFIELD))
    private boolean onGround(LivingEntity instance) {
        return true;
    }


    private static final OldAnimationsLivingEntityBehavior behavior = new OldAnimationsLivingEntityBehavior();
    @Inject(at = @At(value = "HEAD"), method = "isBlocking", cancellable = true)
    private void old_animations$isBlocking(CallbackInfoReturnable<Boolean> callbackInfo) {
        LivingEntity entity = (LivingEntity) (Object) this;
        behavior.modifyIsBlockingBehavior(entity, entity.getActiveItem(), callbackInfo);
    }
}