package net.xpwithdraw.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;

public class WithdrawC2SPacket {
    public static final int MIN_XP_WITHDRAW_AMOUNT = 10;
    public static final int MAX_XP_WITHDRAW_AMOUNT = 2477;
    public static final int XP_STEP = 10;

    public static void recieve(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        server.execute(() -> {
            if(player.totalExperience >= MIN_XP_WITHDRAW_AMOUNT){
                ExperienceOrbEntity.spawn(((ServerWorld)player.world), player.getPos(), calcXp(player.experienceLevel));
                player.addExperience(-calcXp(player.experienceLevel));
                player.experiencePickUpDelay = 0;
            }
        });
    }

    public static int calcXp(int level){
        return MathHelper.clamp(((level <= 15) ? 2 * level + 7 : (level <= 30) ? 5 * level - 38 : 9 * level - 158) / XP_STEP, MIN_XP_WITHDRAW_AMOUNT, MAX_XP_WITHDRAW_AMOUNT);
    }
}
