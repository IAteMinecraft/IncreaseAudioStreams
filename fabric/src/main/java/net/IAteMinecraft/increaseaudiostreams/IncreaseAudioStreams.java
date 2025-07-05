package net.IAteMinecraft.increaseaudiostreams;

import net.fabricmc.api.ModInitializer;

import com.mojang.blaze3d.audio.Library;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import net.minecraft.client.Minecraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncreaseAudioStreams implements ModInitializer {
	public static final String MOD_ID = "increase_audio_streams";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static boolean didRun = false;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            LOGGER.info("Starting to increase Streams...");

            if (!didRun) Minecraft.getInstance().getSoundManager().soundEngine.library.streamingChannels = new Library.CountingChannelPool(32);
			didRun = true;
        });

		LOGGER.info("STREAMS INCREASED!!!");
	}
}