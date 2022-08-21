package net.fantiks.hyukamod.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin{

    @Shadow public abstract ItemStack getActiveItem();

    // Knockback in air
    @Redirect(method = "takeKnockback", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;onGround:Z", opcode = Opcodes.GETFIELD))
    private boolean onGround(LivingEntity instance) {
        return true;
    }

    @ModifyArg(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"), index = 1)
    private float reducedBlockedDamage(float amount) {
        if (((LivingEntity) ((Object) this)) instanceof PlayerEntity && ((LivingEntity) ((Object) this)).getActiveItem().getItem() instanceof SwordItem) {
            return amount/2.0f;
        }
        return amount;
    }
}