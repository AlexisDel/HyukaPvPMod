package net.fantiks.hyukamod.mixin.invoker;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntity.class)
public interface LivingEntityInvoker {

    @Invoker("applyDamage")
    void invokeApplyDamage(DamageSource source, float amount);

    @Invoker("setLivingFlag")
    void invokeSetLivingFlag(int mask, boolean value);

}
