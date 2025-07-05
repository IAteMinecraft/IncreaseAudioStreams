package net.IAteMinecraft.increaseaudiostreams;

import com.mojang.logging.LogUtils;
import com.mojang.blaze3d.audio.Library;

import net.minecraft.client.Minecraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IncreaseAudioStreams.MODID)
public class IncreaseAudioStreams
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "increase_audio_streams";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    private boolean didRun = false;

    public IncreaseAudioStreams() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("Starting to increase Streams...");
        if (!didRun) Minecraft.getInstance().getSoundManager().soundEngine.library.streamingChannels = new Library.CountingChannelPool(32);
        didRun = true;
    }
}
