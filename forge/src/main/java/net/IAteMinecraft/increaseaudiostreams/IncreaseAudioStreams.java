package net.IAteMinecraft.increaseaudiostreams;

import com.mojang.logging.LogUtils;

import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IncreaseAudioStreams.MODID)
public class IncreaseAudioStreams
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "increase_audio_streams";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public IncreaseAudioStreams(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();
        eventBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Starting to increase Streams...");

            MidnightConfig.init(MODID, IASConfig.class);
        });
    }
}
