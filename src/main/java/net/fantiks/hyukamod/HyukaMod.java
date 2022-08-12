package net.fantiks.hyukamod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fantiks.hyukamod.events.LivingHurtCallback;
import net.fantiks.hyukamod.handler.SwordBlockingHandler;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.TypedActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyukaMod implements ModInitializer {
	public static final String MOD_ID = "hyukamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		registerHandlers();
	}

	private void registerHandlers(){
		SwordBlockingHandler swordBlockingHandler = new SwordBlockingHandler();
		UseItemCallback.EVENT.register(swordBlockingHandler::onItemUse);
		LivingHurtCallback.EVENT.register(swordBlockingHandler::onLivingHurt);
	}
}
