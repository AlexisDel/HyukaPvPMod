package net.fantiks.hyukamod.mixin;

import net.fantiks.hyukamod.HyukaMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SwordItem.class)
public abstract class SwordItemMixin extends Item {

    public SwordItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        return TypedActionResult.pass(item);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }
}
