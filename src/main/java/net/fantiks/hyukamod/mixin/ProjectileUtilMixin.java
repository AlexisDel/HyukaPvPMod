package net.fantiks.hyukamod.mixin;

import net.fantiks.hyukamod.behavior.OldPvPBehavior;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ProjectileUtil.class)
public class ProjectileUtilMixin {

    private static OldPvPBehavior oldPvPBehavior = new OldPvPBehavior();

    // Hitboxes inflated by 10%
    @Redirect(method = "raycast", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Box;expand(D)Lnet/minecraft/util/math/Box;"))
    private static Box largerBoundingBox(Box box, double value){
        return oldPvPBehavior.increaseHitBox(box);
    }
}