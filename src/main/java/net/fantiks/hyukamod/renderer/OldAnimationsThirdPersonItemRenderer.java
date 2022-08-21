package net.fantiks.hyukamod.renderer;

import net.fantiks.hyukamod.features.SwordBlockingFeature;
import net.fantiks.hyukamod.features.context.ItemRenderingMatrices;
import net.minecraft.entity.LivingEntity;

public class OldAnimationsThirdPersonItemRenderer {

    public void transformThirdPersonItem(LivingEntity entity, ItemRenderingMatrices matrices) {
        SwordBlockingFeature.LAZY.get().transformThirdPersonItem(entity, matrices);
    }
}
