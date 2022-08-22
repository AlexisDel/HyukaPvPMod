package net.fantiks.hyukamod.mixin.client;

import net.fantiks.hyukamod.render.SwordBlockingRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin<T extends LivingEntity> {

    SwordBlockingRenderer swordBlockingRenderer = new SwordBlockingRenderer();

    @Inject(method = "setAngles", at = @At(value = "TAIL"))
    private void old_animations$setAngles(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo callbackInfo) {
        swordBlockingRenderer.transformThirdPersonEntity((PlayerEntityModel) (Object) this, livingEntity, h);
    }
}
