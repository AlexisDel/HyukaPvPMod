package net.fantiks.hyukamod.client;

import net.fabricmc.api.ModInitializer;
import net.fantiks.hyukamod.registry.ItemRescalingRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyukaModClient implements ModInitializer {
	public static final String MOD_ID = "hyukamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemRescalingRegistry.init();
	}
}
