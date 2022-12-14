package net.fantiks.hyukamod.mixin;

import net.fantiks.hyukamod.mechanics.OldPvPMechanics;
import net.fantiks.hyukamod.render.OldPvPRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    OldPvPMechanics oldPvPMechanics = new OldPvPMechanics();
    OldPvPRenderer oldPvPRenderer = new OldPvPRenderer();

    // Remove all sort of attack cooldown (attack, switch, ...)
    @ModifyConstant(method = "resetLastAttackedTicks", constant = @Constant(intValue = 0))
    private int attack$disableCooldown(int i) {
        return oldPvPMechanics.removeAttackCooldown();
    }

    // Disable sweep attack
    @ModifyConstant(method = "attack", constant = @Constant(intValue = 1), slice = @Slice(from = @At(value = "CONSTANT", args = "classValue=net.minecraft.item.SwordItem")))
    private int attack$SweepAttack(int i) {
        return oldPvPMechanics.disableSweepAttack();
    }

    // Stop disabling sprinting when attacking a target
    @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setSprinting(Z)V"))
    private void attack$setSprinting(PlayerEntity instance, boolean b) {
        oldPvPMechanics.sprintWhileAttacking();
    }

    // Critical hits can be dealt while sprinting
    @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSprinting()Z", ordinal = 1))
    private boolean attack$isSprinting(PlayerEntity instance){
        return oldPvPMechanics.criticalWhileSprinting();
    }

    // Remove Heart Particle when dealing damage
    @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"))
    private <T extends ParticleEffect> int attack$spawnParticles(ServerWorld instance, T particle, double x, double y, double z, int count, double deltaX, double deltaY, double deltaZ, double speed) {
        return oldPvPRenderer.disableHeartParticle();
    }
}
