package net.fantiks.hyukamod.mixin;

import net.fantiks.hyukamod.events.LivingHurtCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin{

    // Knockback in air
    @Redirect(method = "takeKnockback", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;onGround:Z", opcode = Opcodes.GETFIELD))
    private boolean onGround(LivingEntity instance) {
        return true;
    }

    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"), cancellable = true)
    private void onLivingHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        ActionResult result = LivingHurtCallback.EVENT.invoker().interact((LivingEntity) (Object) this, source, amount);

        if(result == ActionResult.FAIL) {
            cir.cancel();
        }
    }
}
