package net.fantiks.hyukamod.renderer;


import net.fantiks.hyukamod.features.ItemRescalingFeature;
import net.fantiks.hyukamod.features.SwordBlockingFeature;
import net.fantiks.hyukamod.features.context.ItemRenderingFeatureExecutionContext;
import net.fantiks.hyukamod.features.context.ItemRenderingMatrices;
import net.fantiks.hyukamod.features.context.ItemRenderingProgress;
import net.fantiks.hyukamod.utils.Lazy;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class OldAnimationsHeldItemRenderer {

    private static final Lazy<ItemRescalingFeature> itemRescalingFeature = Lazy.create(ItemRescalingFeature::new);

    public void transformRender(
        AbstractClientPlayerEntity player,
        float tickDelta,
        float pitch,
        Hand hand,
        float swingProgress,
        ItemStack item,
        float equipProgress,
        MatrixStack matrixStack,
        VertexConsumerProvider vertexConsumers,
        CallbackInfo callbackInfo
    ) {
        if (item.getItem() instanceof SwordItem && player.isUsingItem()) {
            ItemRenderingFeatureExecutionContext context = ItemRenderingFeatureExecutionContext.create(
                callbackInfo, item, hand, new ItemRenderingMatrices(vertexConsumers, matrixStack),
                new ItemRenderingProgress(swingProgress, equipProgress, tickDelta)
            );
            SwordBlockingFeature.LAZY.get().transform(context);
            return;
        }
        ItemRenderingFeatureExecutionContext context = ItemRenderingFeatureExecutionContext.create(callbackInfo, item, hand, new ItemRenderingMatrices(vertexConsumers, matrixStack), new ItemRenderingProgress(swingProgress, equipProgress, tickDelta));
        itemRescalingFeature.get().transform(context);
    }
}
