package net.xpwithdraw;

import net.fabricmc.api.ClientModInitializer;
import net.xpwithdraw.event.KeyInputHandler;
import net.xpwithdraw.networking.ModMessages;

public class XpWithdrawClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        ModMessages.registerS2CPackets();
    }
    
}
