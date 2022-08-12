package net.fantiks.hyukamod.handler;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fantiks.hyukamod.HyukaMod;
import net.fantiks.hyukamod.mixin.PlayerEntityMixin;
import net.fantiks.hyukamod.mixin.invoker.LivingEntityInvoker;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SwordBlockingHandler {

    public TypedActionResult<ItemStack> onItemUse(PlayerEntity playerEntity, World world, Hand hand) {
        if (playerEntity.getStackInHand(hand).getItem() instanceof SwordItem) {
            ItemStack itemStack = playerEntity.getStackInHand(hand);
            playerEntity.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.pass(playerEntity.getStackInHand(hand));
    }

    public ActionResult onLivingHurt(LivingEntity entity, DamageSource source, float amount) {
        HyukaMod.LOGGER.info(String.valueOf(entity.isUsingItem()));
        if (entity instanceof PlayerEntity && entity.getActiveItem().getItem() instanceof SwordItem && entity.isUsingItem()){
            HyukaMod.LOGGER.info("OK");
            ((LivingEntityInvoker) entity).invokeApplyDamage(source, amount / 2.0f);
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }
}