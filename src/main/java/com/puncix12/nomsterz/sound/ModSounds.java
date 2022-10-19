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
    public static final RegistryObject<SoundEvent> YONSI_IDLE =
            registerSoundEvent("yonsi_idle");
    public static final RegistryObject<SoundEvent> YONSI_HIT =
            registerSoundEvent("yonsi_hit");
    public static final RegistryObject<SoundEvent> YONSI_DEATH =
            registerSoundEvent("yonsi_death");
    public static final RegistryObject<SoundEvent> YONSI_ATTACK =
            registerSoundEvent("yonsi_attack");
    public static final RegistryObject<SoundEvent> PELLATT_IDLE =
            registerSoundEvent("pellatt_idle");
    public static final RegistryObject<SoundEvent> PELLATT_HIT =
            registerSoundEvent("pellatt_hit");
    public static final RegistryObject<SoundEvent> PELLATT_DEATH =
            registerSoundEvent("pellatt_death");
    public static final RegistryObject<SoundEvent> PELLATT_ATTACK =
            registerSoundEvent("pellatt_attack");
    public static final RegistryObject<SoundEvent> GHOGA_HIT =
            registerSoundEvent("ghoga_hit");
    public static final RegistryObject<SoundEvent> GHOGA_IDLE =
            registerSoundEvent("ghoga_idle");
    public static final RegistryObject<SoundEvent> GHOGA_DEATH =
            registerSoundEvent("ghoga_death");
    public static final RegistryObject<SoundEvent> KASHISOS_HIT =
            registerSoundEvent("kashisos_hit");
    public static final RegistryObject<SoundEvent> KASHISOS_IDLE =
            registerSoundEvent("kashisos_idle");
    public static final RegistryObject<SoundEvent> KASHISOS_DEATH =
            registerSoundEvent("kashisos_death");
    public static final RegistryObject<SoundEvent> OHANUSH_IDLE =
            registerSoundEvent("ohanush_idle");
    public static final RegistryObject<SoundEvent> OHANUSH_HIT =
            registerSoundEvent("ohanush_hit");
    public static final RegistryObject<SoundEvent> OHANUSH_DEATH =
            registerSoundEvent("ohanush_death");
    public static final RegistryObject<SoundEvent> OHANUSH_ATTACK =
            registerSoundEvent("ohanush_attack");
    public static final RegistryObject<SoundEvent> ROHARK_IDLE =
            registerSoundEvent("rohark_idle");
    public static final RegistryObject<SoundEvent> ROHARK_HIT =
            registerSoundEvent("rohark_hit");
    public static final RegistryObject<SoundEvent> ROHARK_DEATH =
            registerSoundEvent("rohark_death");
    public static final RegistryObject<SoundEvent> ROHARK_ATTACK =
            registerSoundEvent("rohark_attack");
    public static final RegistryObject<SoundEvent> AHAGRIOQ_HIT =
            registerSoundEvent("ahagrioq_hit");
    public static final RegistryObject<SoundEvent> AHAGRIOQ_DEATH =
            registerSoundEvent("ahagrioq_death");
    public static final RegistryObject<SoundEvent> AHAGRIOQ_IDLE =
            registerSoundEvent("ahagrioq_idle");
    public static final RegistryObject<SoundEvent> IVEKROC_HIT =
            registerSoundEvent("ivekroc_hit");
    public static final RegistryObject<SoundEvent> IVEKROC_DEATH =
            registerSoundEvent("ivekroc_death");
    public static final RegistryObject<SoundEvent> IVEKROC_IDLE =
            registerSoundEvent("ivekroc_idle");
    public static final RegistryObject<SoundEvent> EMABRI_HIT =
            registerSoundEvent("emabri_hit");
    public static final RegistryObject<SoundEvent> EMABRI_IDLE =
            registerSoundEvent("emabri_idle");
    public static final RegistryObject<SoundEvent> DERRMUES_IDLE1 =
            registerSoundEvent("derrmues_idle1");
    public static final RegistryObject<SoundEvent> DERRMUES_IDLE2 =
            registerSoundEvent("derrmues_idle2");
    public static final RegistryObject<SoundEvent> DERRMUES_ATTACK =
            registerSoundEvent("derrmues_attack");
    public static final RegistryObject<SoundEvent> DERRMUES_HIT =
            registerSoundEvent("derrmues_hit");
    public static final RegistryObject<SoundEvent> DERRMUES_DEATH =
            registerSoundEvent("derrmues_death");
    public static final RegistryObject<SoundEvent> PIARA_DEATH =
            registerSoundEvent("piara_death");
    public static final RegistryObject<SoundEvent> PIARA_IDLE =
            registerSoundEvent("piara_idle");
    public static final RegistryObject<SoundEvent> PIARA_HIT =
            registerSoundEvent("piara_hit");
    public static final RegistryObject<SoundEvent> PIARA_ATTACK =
            registerSoundEvent("piara_attack");
    public static final RegistryObject<SoundEvent> OSIPITI_HIT =
            registerSoundEvent("osipiti_hit");
    public static final RegistryObject<SoundEvent> OSIPITI_IDLE =
            registerSoundEvent("osipiti_idle");
    public static final RegistryObject<SoundEvent> OSIPITI_ATTACK =
            registerSoundEvent("osipiti_attack");
    public static final RegistryObject<SoundEvent> WAPAULENDO_ATTACK =
            registerSoundEvent("wapaulendo_attack");
    public static final RegistryObject<SoundEvent> WAPAULENDO_HIT =
            registerSoundEvent("wapaulendo_hit");
    public static final RegistryObject<SoundEvent> WAPAULENDO_IDLE =
            registerSoundEvent("wapaulendo_idle");
    public static final RegistryObject<SoundEvent> AGWO_IDLE =
            registerSoundEvent("agwo_idle");
    public static final RegistryObject<SoundEvent> AGWO_ATTACK =
            registerSoundEvent("agwo_attack");
    public static final RegistryObject<SoundEvent> AGWO_HIT =
            registerSoundEvent("agwo_hit");
    public static final RegistryObject<SoundEvent> BEKOR_ATTACK =
            registerSoundEvent("bekor_attack");
    public static final RegistryObject<SoundEvent> BEKOR_HIT =
            registerSoundEvent("bekor_hit");
    public static final RegistryObject<SoundEvent> BEKOR_IDLE =
            registerSoundEvent("bekor_idle");
    public static final RegistryObject<SoundEvent> BEKOR_DEATH =
            registerSoundEvent("bekor_death");
    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Nomsterz.MOD_ID, name)));
    }
    public static void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }
}
