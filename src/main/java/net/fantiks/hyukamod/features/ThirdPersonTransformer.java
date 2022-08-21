package net.fantiks.hyukamod.features;

import net.fantiks.hyukamod.features.context.ItemRenderingMatrices;
import net.fantiks.hyukamod.utils.PlayerEntityModelAccess;
import net.minecraft.entity.LivingEntity;

public interface ThirdPersonTransformer {

    void transformThirdPersonItem(LivingEntity entity, ItemRenderingMatrices matrices);

    void transformThirdPersonEntity(PlayerEntityModelAccess model, LivingEntity entity, float ticks);

}
