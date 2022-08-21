package net.fantiks.hyukamod.features.context;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

public class DefaultItemRenderingFeatureExecutionContext implements ItemRenderingFeatureExecutionContext {

    private final CallbackInfo callbackInfo;
    private final PlayerEntity player;
    private final ItemStack item;
    private final Hand hand;
    private final ItemRenderingMatrices matrices;
    private final ItemRenderingProgress progress;

    public DefaultItemRenderingFeatureExecutionContext(CallbackInfo callbackInfo, PlayerEntity player, ItemStack item, Hand hand, ItemRenderingMatrices matrices, ItemRenderingProgress progress) {
        this.callbackInfo = callbackInfo;
        this.item = item;
        this.hand = hand;
        this.matrices = matrices;
        this.progress = progress;
        this.player = player;
    }

    @Override
    public PlayerEntity player() {
        return player;
    }

    @Override
    public CallbackInfo callbackInfo() {
        return callbackInfo;
    }

    @Override
    public ItemStack itemStack() {
        return item;
    }

    @Override
    public Hand hand() {
        return hand;
    }

    @Override
    public ItemRenderingMatrices matrices() {
        return matrices;
    }

    @Override
    public Optional<ItemRenderingProgress> progress() {
        return Optional.ofNullable(progress);
    }
}
