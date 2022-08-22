package net.fantiks.hyukamod.mechanics;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;

public class SwordBlocking {

    public float blockDamage(LivingEntity entity, float damage) {
        if (entity instanceof PlayerEntity && entity.getActiveItem().getItem() instanceof SwordItem) {
            return damage/2.0f;
        }
        return damage;
    }

}
