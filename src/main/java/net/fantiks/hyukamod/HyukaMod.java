package net.fantiks.hyukamod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fantiks.hyukamod.handler.ClassicCombatHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyukaMod implements ModInitializer {
	public static final String MOD_ID = "hyukamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		registerHandlers();
	}

	private static void registerHandlers(){

		final ClassicCombatHandler classicCombatHandler = new ClassicCombatHandler();
		AttackEntityCallback.EVENT.register(ClassicCombatHandler::onAttackEntity);
	}
}
