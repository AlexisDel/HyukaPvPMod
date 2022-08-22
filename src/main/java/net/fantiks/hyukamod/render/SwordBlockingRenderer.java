package net.fantiks.hyukamod.render;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;

public class SwordBlockingRenderer {

    private static final Quaternion THIRD_PERSON_QUATERNION = new Quaternion(Vec3f.POSITIVE_Y, -45f, true);

    public void firstPersonSwordBlockingRender(Hand hand, MatrixStack matrixStack) {
        int side = hand == Hand.MAIN_HAND ? 1 : -1;
        matrixStack.translate(side * -0.14142136f, 0.08f, 0.14142136f);
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-102.25f));
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(side * 13.365f));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(side * 78.05f));
    }

    public void thirdPersonSwordBlockingRender(MatrixStack matrixStack) {
        matrixStack.translate(-0.14142136f, -0.05f, 0.14142136f);
        matrixStack.multiply(THIRD_PERSON_QUATERNION);
    }
}
