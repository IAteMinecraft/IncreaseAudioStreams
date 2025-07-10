package net.IAteMinecraft.increaseaudiostreams.mixin;

import com.mojang.blaze3d.audio.Library;

import net.IAteMinecraft.increaseaudiostreams.IASConfig;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.IAteMinecraft.increaseaudiostreams.IncreaseAudioStreams.LOGGER;

@Mixin(targets = "com.mojang.blaze3d.audio.Library")
public class LibraryMixin {

    @Shadow
    private Library.ChannelPool streamingChannels;

    @Inject(method = "init(Ljava/lang/String;Z)V", at = @At("TAIL"))
    private void init(String string, boolean bl, CallbackInfo ci) {

        this.streamingChannels = new Library.CountingChannelPool(IASConfig.streamCount);

        LOGGER.info("STREAMS INCREASED!!!");
    }
}

