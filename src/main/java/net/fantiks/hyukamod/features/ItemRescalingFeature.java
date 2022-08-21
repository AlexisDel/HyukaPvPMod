package net.fantiks.hyukamod.features;

import net.fantiks.hyukamod.features.context.ItemRenderingFeatureExecutionContext;
import net.fantiks.hyukamod.registry.ItemRescalingRegistry;
import net.fantiks.hyukamod.utils.ItemRescaling;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;

import java.util.Optional;

public class ItemRescalingFeature implements ItemRenderingFeature<ItemRenderingFeatureExecutionContext> {

    @Override
    public void transform(ItemRenderingFeatureExecutionContext context) {
        Optional<ItemRescaling> rescaling = ItemRescalingRegistry.find(context.itemStack().getItem());
        if (rescaling.isPresent()) {
            Vec3f position = rescaling.get().position();
            Vec3f scale = rescaling.get().scale();
            MatrixStack matrices = context.matrices().stack();
            matrices.translate(position.getX(), position.getY(), position.getZ());
            matrices.scale(scale.getX(), scale.getY(), scale.getZ());
        }
    }

}
