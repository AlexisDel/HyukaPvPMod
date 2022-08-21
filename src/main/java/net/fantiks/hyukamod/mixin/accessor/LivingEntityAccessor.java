package net.fantiks.hyukamod.mixin.accessor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {

    @Accessor()
    ItemStack getActiveItemStack();

    @Accessor("activeItemStack")
    void setActiveItemStack(ItemStack itemStack);

    @Accessor("itemUseTimeLeft")
    void setItemUseTimeLeft(int itemUseTimeLeft);
}
