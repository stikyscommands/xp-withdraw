package net.xpwithdraw.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.xpwithdraw.XpWithdraw;
import net.xpwithdraw.networking.packet.WithdrawC2SPacket;

public class ModMessages {
    public static final Identifier WITHDRAW_ID = new Identifier(XpWithdraw.MOD_ID, "withdraw");
    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(WITHDRAW_ID, WithdrawC2SPacket::recieve);
    }

    public static void registerS2CPackets(){

    }
}
