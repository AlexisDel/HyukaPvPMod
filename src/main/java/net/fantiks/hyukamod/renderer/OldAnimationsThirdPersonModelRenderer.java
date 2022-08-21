package net.fantiks.hyukamod.renderer;

import net.fantiks.hyukamod.features.SwordBlockingFeature;
import net.fantiks.hyukamod.utils.PlayerEntityModelAccess;
import net.minecraft.entity.LivingEntity;

public class OldAnimationsThirdPersonModelRenderer {

    public void transformThirdPersonModel(LivingEntity entity, PlayerEntityModelAccess entityModelAccess, float ticks) {
        SwordBlockingFeature.LAZY.get().transformThirdPersonEntity(entityModelAccess, entity, ticks);
    }
}
