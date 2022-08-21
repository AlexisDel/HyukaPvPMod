package net.fantiks.hyukamod.client.mixin.gui;

import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.option.Option;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VideoOptionsScreen.class)
public class VideoOptionsScreenMixin {

    @Shadow private ButtonListWidget list;

    // Remove AttackIndicator button from video setting screen
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/ButtonListWidget;addAll([Lnet/minecraft/client/option/Option;)V"))
    private void removeAttackIndicatorButton(ButtonListWidget instance, Option[] options) {
        this.list.addAll(new Option[]{Option.GRAPHICS, Option.RENDER_DISTANCE, Option.CHUNK_BUILDER_MODE, Option.SIMULATION_DISTANCE, Option.AO, Option.FRAMERATE_LIMIT, Option.VSYNC, Option.VIEW_BOBBING, Option.GUI_SCALE, Option.GAMMA, Option.CLOUDS, Option.FULLSCREEN, Option.PARTICLES, Option.MIPMAP_LEVELS, Option.ENTITY_SHADOWS, Option.DISTORTION_EFFECT_SCALE, Option.ENTITY_DISTANCE_SCALING, Option.FOV_EFFECT_SCALE, Option.SHOW_AUTOSAVE_INDICATOR});
    }
}
