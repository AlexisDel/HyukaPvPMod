package net.fantiks.hyukamod.features.context;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class DefaultFeatureExecutionContext implements FeatureExecutionContext {

    private final PlayerEntity player;
    private final CallbackInfo callbackInfo;

    public DefaultFeatureExecutionContext(
        PlayerEntity player, CallbackInfo callbackInfo
    ) {
        this.player = player;
        this.callbackInfo = callbackInfo;
    }

    @Override
    public PlayerEntity player() {
        return player;
    }

    @Override
    public CallbackInfo callbackInfo() {
        return callbackInfo;
    }

}
