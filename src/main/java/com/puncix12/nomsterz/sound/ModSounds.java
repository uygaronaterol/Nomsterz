package com.puncix12.nomsterz.sound;

import com.puncix12.nomsterz.Nomsterz;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Nomsterz.MOD_ID);

    public static final RegistryObject<SoundEvent> NYANGA_IDLE =
            registerSoundEvent("nyanga_idle");
    public static final RegistryObject<SoundEvent> NYANGA_IDLE2 =
            registerSoundEvent("nyanga_idle2");
    public static final RegistryObject<SoundEvent> NYANGA_HIT =
            registerSoundEvent("nyanga_hit");
    public static final RegistryObject<SoundEvent> NYANGA_DEATH =
            registerSoundEvent("nyanga_death");
    public static final RegistryObject<SoundEvent> NATSHAI_IDLE =
            registerSoundEvent("natshai_idle");
    public static final RegistryObject<SoundEvent> NATSHAI_HIT =
            registerSoundEvent("natshai_hit");
    public static final RegistryObject<SoundEvent> NATSHAI_DEATH =
            registerSoundEvent("natshai_death");
    public static final RegistryObject<SoundEvent> SWERDARM_IDLE =
            registerSoundEvent("swerdarm_idle");
    public static final RegistryObject<SoundEvent> SWERDARM_HIT =
            registerSoundEvent("swerdarm_hit");
    public static final RegistryObject<SoundEvent> SWERDARM_DEATH =
            registerSoundEvent("swerdarm_death");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Nomsterz.MOD_ID, name)));
    }
    public static void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }
}
