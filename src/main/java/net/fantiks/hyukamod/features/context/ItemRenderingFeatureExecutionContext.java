package net.fantiks.hyukamod.features.context;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

public interface ItemRenderingFeatureExecutionContext extends FeatureExecutionContext {

    static ItemRenderingFeatureExecutionContext create(CallbackInfo callbackInfo, PlayerEntity player, ItemStack item, Hand hand, ItemRenderingMatrices matrices, ItemRenderingProgress progress) {
        return new DefaultItemRenderingFeatureExecutionContext(callbackInfo, player, item, hand, matrices, progress);
    }

    static ItemRenderingFeatureExecutionContext create(CallbackInfo callbackInfo, ItemStack item, Hand hand, ItemRenderingMatrices matrices, ItemRenderingProgress progress) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        return new DefaultItemRenderingFeatureExecutionContext(callbackInfo, player, item, hand, matrices, progress);
    }

    ItemStack itemStack();

    Hand hand();

    ItemRenderingMatrices matrices();

    Optional<ItemRenderingProgress> progress();

}
