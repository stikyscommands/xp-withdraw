package net.xpwithdraw;

import net.fabricmc.api.ModInitializer;
import net.xpwithdraw.networking.ModMessages;

public class XpWithdraw implements ModInitializer {
	public static final String MOD_ID = "xpwithdraw";

	@Override
	public void onInitialize() {
		ModMessages.registerC2SPackets();
	}
}
