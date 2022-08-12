package net.fantiks.hyukamod.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SwordItem.class)
public abstract class SwordItemMixin extends ToolItem {
    public SwordItemMixin(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }
}
