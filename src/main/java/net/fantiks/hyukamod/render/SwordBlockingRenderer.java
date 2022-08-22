package net.fantiks.hyukamod.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.Transformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;

public class SwordBlockingRenderer {

    private static final Quaternion THIRD_PERSON_QUATERNION = new Quaternion(Vec3f.POSITIVE_Y, -45f, true);

    public void thirdPersonSwordBlockingRender(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transformationMode, Arm arm, MatrixStack matrixStack) {
        matrixStack.translate(-0.14142136f, -0.5f, 0.14142136f);
        matrixStack.multiply(THIRD_PERSON_QUATERNION);
    }

    /*
    private void applyItemBlockingTransform( MatrixStack matrixStack, boolean leftHand) {
        matrixStack.translate((leftHand ? 1.0F : -1.0F) / 16.0F, 0.4375F, 0.0625F);
        // blocking
        matrixStack.translate(leftHand ? -0.035F : 0.05F, leftHand ? 0.045F : 0.0F, leftHand ? -0.135F : -0.1F);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((leftHand ? -1.0F : 1.0F) * -50.0F));
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-10.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((leftHand ? -1.0F : 1.0F) * -60.0F));
        // old item layer
        matrixStack.translate(0.0F, 0.1875F, 0.0F);
        // this differs from 1.7 as there was a negative y scale being used, which is not supported on Minecraft 1.16+
        // therefore rotations on X and Y all had to be flipped down the line (and one rotation on X by 180 degrees has been added)
        matrixStack.scale(0.625F, 0.625F, 0.625F);
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180.0F));
        matrixStack.multiply(Vec3f.NEGATIVE_X.getDegreesQuaternion(-100.0F));
        matrixStack.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(leftHand ? 35.0F : 45.0F));
        // old item renderer
        matrixStack.translate(0.0F, -0.3F, 0.0F);
        matrixStack.scale(1.5F, 1.5F, 1.5F);
        matrixStack.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(50.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(335.0F));
        matrixStack.translate(-0.9375F, -0.0625F, 0.0F);
        matrixStack.translate(0.5F, 0.5F, 0.25F);
        matrixStack.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(180.0F));
        matrixStack.translate(0.0F, 0.0F, 0.28125F);
    }

    private void applyItemTransformInverse(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transform, MatrixStack matrixStack, boolean leftHand) {
        // revert 1.8+ model changes, so we can work on a blank slate
        BakedModel model = MinecraftClient.getInstance().getItemRenderer().getModel(stack, entity.world, entity, 0);
        applyTransformInverse(model.getTransformation().getTransformation(transform), leftHand, matrixStack);
    }

    private static void applyTransformInverse(Transformation vec, boolean leftHand, MatrixStack matrixStackIn) {
        // this does the exact inverse of ItemTransform::apply which should be applied right after, so that in the end nothing has changed
        if (vec != Transformation.IDENTITY) {
            float angleX = vec.rotation.getX();
            float angleY = leftHand ? -vec.rotation.getY() : vec.rotation.getY();
            float angleZ = leftHand ? -vec.rotation.getZ() : vec.rotation.getZ();
            Quaternion quaternion = new Quaternion(angleX, angleY, angleZ, true);
            quaternion.conjugate();

            matrixStackIn.scale(1.0F / vec.scale.getX(), 1.0F / vec.scale.getY(), 1.0F / vec.scale.getZ());
            matrixStackIn.multiply(quaternion);
            matrixStackIn.translate((leftHand ? -1.0F : 1.0F) * -vec.translation.getX(), -vec.translation.getY(), -vec.translation.getZ());
        }
    }
    */

    public void transformThirdPersonEntity(PlayerEntityModel model, LivingEntity livingEntity, float ticks) {
        PlayerEntityModel<?> playerEntityModel = (PlayerEntityModel<?>) model;
        int side = livingEntity.getStackInHand(Hand.MAIN_HAND).getItem() instanceof SwordItem ? 1 : -1;
        (side == 1 ? playerEntityModel.rightArm : playerEntityModel.leftArm).pitch = -0.75f;
    }

    public void firstPersonSwordBlockingRender(Hand hand, MatrixStack matrixStack, float swingProgress) {

        int i = hand == Hand.MAIN_HAND ? 1 : -1;
        float f = MathHelper.sin(swingProgress * swingProgress * (float)Math.PI);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((float)i * (45.0F + f * -20.0F)));
        float f1 = MathHelper.sin(MathHelper.sqrt(swingProgress) * (float)Math.PI);
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((float)i * f1 * -20.0F));
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(f1 * -80.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((float)i * -45.0F));

        int side = hand == Hand.MAIN_HAND ? 1 : -1;
        matrixStack.translate(side * -0.14142136f, 0.08f, 0.14142136f);
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-102.25f));
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(side * 13.365f));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(side * 78.05f));
    }
}
