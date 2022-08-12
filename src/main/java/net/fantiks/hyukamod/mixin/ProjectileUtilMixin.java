package net.fantiks.hyukamod.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ProjectileUtil.class)
public class ProjectileUtilMixin {

    // Hitboxes inflated by 10%
    @Redirect(method = "raycast", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Box;expand(D)Lnet/minecraft/util/math/Box;"))
    private static Box largerBoundingBox(Box box, double value){
        return box.stretch(0.1, 0.1, 0.1);
    }
}