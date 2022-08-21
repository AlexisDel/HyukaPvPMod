package net.fantiks.hyukamod.renderer;

import net.fantiks.hyukamod.features.OldSneakingFeature;
import net.fantiks.hyukamod.features.context.FeatureExecutionContext;
import net.fantiks.hyukamod.utils.CameraAccess;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Lazy;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class OldAnimationsCamera {

    private static final Lazy<OldSneakingFeature> feature = new Lazy<>(OldSneakingFeature::new);

    public void removeSmoothing(CameraAccess camera, CallbackInfo callbackInfo) {
        Entity focusedEntity = camera.getFocusedEntity();
        if (!(focusedEntity instanceof PlayerEntity)) {
            return;
        }
        FeatureExecutionContext context = FeatureExecutionContext.create((PlayerEntity) focusedEntity, callbackInfo);
        feature.get().transform(context);
    }
}