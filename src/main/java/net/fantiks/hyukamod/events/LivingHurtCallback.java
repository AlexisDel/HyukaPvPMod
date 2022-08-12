package net.fantiks.hyukamod.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface LivingHurtCallback {

    Event<LivingHurtCallback> EVENT = EventFactory.createArrayBacked(LivingHurtCallback.class,
            (listeners) -> (entity, source, amount) -> {
                for (LivingHurtCallback listener : listeners) {
                    ActionResult result = listener.interact(entity, source, amount);

                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult interact(LivingEntity entity, DamageSource source, float amount);
}
