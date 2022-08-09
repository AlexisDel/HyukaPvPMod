package net.fantiks.hyukamod.handler;

import net.fantiks.hyukamod.mixin.accessor.LivingEntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ClassicCombatHandler {

    public static ActionResult onAttackEntity(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult entityHitResult) {
        ((LivingEntityAccessor) playerEntity).setLastAttackedTicks(9999);
        playerEntity.sendMessage(Text.of(playerEntity.getItemsHand().iterator().next().toString()),false);
        return ActionResult.PASS;
    }
}
