package net.fantiks.hyukamod.mixin.accessor;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {

    @Accessor("lastAttackedTicks")
    public void setLastAttackedTicks(int lastAttackedTicks);


}
