package net.IAteMinecraft.increaseaudiostreams.mixin;

import com.mojang.blaze3d.audio.Library;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.IAteMinecraft.increaseaudiostreams.IncreaseAudioStreams.LOGGER;

@Mixin(targets = "com.mojang.blaze3d.audio.Library")
public class LibraryMixin {

    @Shadow public Library.ChannelPool streamingChannels;

    @Inject(method = "Lcom/mojang/blaze3d/audio/Library;init(Ljava/lang/String;Z)V", at = @At("TAIL"))
    private void init(String string, boolean bl, CallbackInfo ci) {

        this.streamingChannels = new Library.CountingChannelPool(32);

        LOGGER.info("STREAMS INCREASED!!!");
    }
}

