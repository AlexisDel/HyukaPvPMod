package net.fantiks.hyukamod.mixin;

import net.fantiks.hyukamod.mechanics.OldPvPMechanics;
import net.fantiks.hyukamod.mechanics.SwordBlocking;
import net.minecraft.entity.LivingEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin{

    OldPvPMechanics oldPvPMechanics = new OldPvPMechanics();
    SwordBlocking swordBlocking = new SwordBlocking();

    // Knockback in air
    @Redirect(method = "takeKnockback", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;onGround:Z", opcode = Opcodes.GETFIELD))
    private boolean onGround(LivingEntity instance) {
        return oldPvPMechanics.takeKnockBackInAir();
    }

    @ModifyArg(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"), index = 1)
    private float reducedBlockedDamage(float amount) {
        return swordBlocking.blockDamage(((LivingEntity) ((Object) this)), amount);
    }
}