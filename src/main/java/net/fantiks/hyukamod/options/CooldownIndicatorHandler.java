package net.fantiks.hyukamod.options;

import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.option.Option;

public class CooldownIndicatorHandler {

    public AttackIndicator disableInGameAttackIndicator() {
        return AttackIndicator.OFF;
    }

    public void disableAttackIndicatorSetting(ButtonListWidget list) {
        list.addAll(new Option[]{Option.GRAPHICS, Option.RENDER_DISTANCE, Option.CHUNK_BUILDER_MODE, Option.SIMULATION_DISTANCE, Option.AO, Option.FRAMERATE_LIMIT, Option.VSYNC, Option.VIEW_BOBBING, Option.GUI_SCALE, Option.GAMMA, Option.CLOUDS, Option.FULLSCREEN, Option.PARTICLES, Option.MIPMAP_LEVELS, Option.ENTITY_SHADOWS, Option.DISTORTION_EFFECT_SCALE, Option.ENTITY_DISTANCE_SCALING, Option.FOV_EFFECT_SCALE, Option.SHOW_AUTOSAVE_INDICATOR});
    }
}
