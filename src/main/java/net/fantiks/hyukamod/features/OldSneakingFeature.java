package net.fantiks.hyukamod.features;

import net.fantiks.hyukamod.features.context.FeatureExecutionContext;
import net.fantiks.hyukamod.utils.CameraAccess;
import net.minecraft.client.MinecraftClient;

public class OldSneakingFeature implements OldAnimationsFeature<FeatureExecutionContext> {

   @Override
   public void transform(FeatureExecutionContext context) {
       if (context.player().isSneaking()) {
           CameraAccess camera = (CameraAccess) MinecraftClient.getInstance().gameRenderer.getCamera();
           camera.setCameraY(camera.getFocusedEntity().getStandingEyeHeight());
      }
   }
}
