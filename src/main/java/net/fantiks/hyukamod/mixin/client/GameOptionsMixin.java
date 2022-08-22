package net.fantiks.hyukamod.mixin.client;

import net.fantiks.hyukamod.options.CooldownIndicatorHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(GameOptions.class)
public class GameOptionsMixin {

    CooldownIndicatorHandler cooldownIndicatorHandler = new CooldownIndicatorHandler();

    @Shadow private AttackIndicator attackIndicator;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void disableAttackIndicator(MinecraftClient client, File optionsFile, CallbackInfo ci){
        attackIndicator = cooldownIndicatorHandler.disableInGameAttackIndicator();
    }
}
