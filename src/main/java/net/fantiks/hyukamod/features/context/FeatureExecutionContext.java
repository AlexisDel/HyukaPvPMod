package net.fantiks.hyukamod.features.context;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * The context needed to perform a transformation on a feature.
 */
public interface FeatureExecutionContext {

    static FeatureExecutionContext create(PlayerEntity player, CallbackInfo callbackInfo) {
        return new DefaultFeatureExecutionContext(player, callbackInfo);
    }

    static FeatureExecutionContext create(CallbackInfo callbackInfo) {
        return create(MinecraftClient.getInstance().player, callbackInfo);
    }

    PlayerEntity player();

    CallbackInfo callbackInfo();
}
