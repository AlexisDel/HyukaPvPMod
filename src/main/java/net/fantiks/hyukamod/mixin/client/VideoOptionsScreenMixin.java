package net.fantiks.hyukamod.mixin.client;

import net.fantiks.hyukamod.options.CooldownIndicatorHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Option;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VideoOptionsScreen.class)
public class VideoOptionsScreenMixin {

    CooldownIndicatorHandler cooldownIndicatorHandler = new CooldownIndicatorHandler();

    @Shadow private ButtonListWidget list;

    // Remove AttackIndicator button from video setting screen
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/ButtonListWidget;addAll([Lnet/minecraft/client/option/Option;)V"))
    private void removeAttackIndicatorButton(ButtonListWidget instance, Option[] options) {
        cooldownIndicatorHandler.disableAttackIndicatorSetting(this.list);
    }
}
