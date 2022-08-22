package net.fantiks.hyukamod.mixin.client;

import net.fantiks.hyukamod.HyukaMod;
import net.fantiks.hyukamod.render.SwordBlockingRenderer;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    SwordBlockingRenderer swordBlockingRenderer = new SwordBlockingRenderer();

    @Inject(
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"
        ),
        method = "renderFirstPersonItem",
        cancellable = true
    )
    private void old_animations$renderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light, CallbackInfo callbackInfo) {
        if (item.getItem() instanceof SwordItem && player.isUsingItem()) {
            swordBlockingRenderer.firstPersonSwordBlockingRender(hand, matrixStack, swingProgress);
        }
    }
}
