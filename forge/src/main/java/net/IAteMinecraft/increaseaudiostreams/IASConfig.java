package net.IAteMinecraft.increaseaudiostreams;


import eu.midnightdust.lib.config.MidnightConfig;

public class IASConfig extends MidnightConfig {
    public static final String TEXT = "text";
    public static final String NUMBERS = "numbers";
    public static final String SLIDERS = "sliders";
    public static final String LISTS = "lists";
    public static final String FILES = "files";
    public static final String CONDITIONS = "conditions";


    @Entry(category = NUMBERS) public static int streamCount = 32;
}
