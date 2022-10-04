package com.puncix12.nomsterz.entity;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Nomsterz.MOD_ID);

    public static final RegistryObject<EntityType<NatshaiEntity>> NATSHAI =
            ENTITY_TYPES.register("natshai",
                    () -> EntityType.Builder.of(NatshaiEntity::new, MobCategory.CREATURE).sized(1f,0.6f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "nathsai").toString()));
    public static final RegistryObject<EntityType<NyangaEntity>> NYANGA =
            ENTITY_TYPES.register("nyanga",
                    () -> EntityType.Builder.of(NyangaEntity::new, MobCategory.CREATURE).sized(2f,2f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "nyanga").toString()));
    public static final RegistryObject<EntityType<SwerdarmEntity>> SWERDARM =
            ENTITY_TYPES.register("swerdarm",
                    () -> EntityType.Builder.of(SwerdarmEntity::new, MobCategory.CREATURE).sized(2f,2f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "swerdarm").toString()));
    public static final RegistryObject<EntityType<PellattEntity>> PELLATT =
            ENTITY_TYPES.register("pellatt",
                    () -> EntityType.Builder.of(PellattEntity::new, MobCategory.CREATURE).sized(1.4f,1.4f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "pellatt").toString()));
    public static final RegistryObject<EntityType<GhogaEntity>> GHOGA =
            ENTITY_TYPES.register("ghoga",
                    () -> EntityType.Builder.of(GhogaEntity::new, MobCategory.CREATURE).sized(1f,1f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "ghoga").toString()));
    public static final RegistryObject<EntityType<YonsiEntity>> YONSI =
            ENTITY_TYPES.register("yonsi",
                    () -> EntityType.Builder.of(YonsiEntity::new, MobCategory.CREATURE).sized(1.5f,2f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "yonsi").toString()));
    public static final RegistryObject<EntityType<RoharkEntity>> ROHARK =
            ENTITY_TYPES.register("rohark",
                    () -> EntityType.Builder.of(RoharkEntity::new, MobCategory.CREATURE).sized(1f,0.6f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "rohark").toString()));
    public static final RegistryObject<EntityType<KashisosEntity>> KASHISOS =
            ENTITY_TYPES.register("kashisos",
                    () -> EntityType.Builder.of(KashisosEntity::new, MobCategory.CREATURE).sized(1f,0.6f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "kashisos").toString()));
    public static final RegistryObject<EntityType<OhanushEntity>> OHANUSH =
            ENTITY_TYPES.register("ohanush",
                    () -> EntityType.Builder.of(OhanushEntity::new, MobCategory.CREATURE).sized(1f,1.6f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "ohanush").toString()));
    public static final RegistryObject<EntityType<AhagrioqEntity>> AHAGRIOQ =
            ENTITY_TYPES.register("ahagrioq",
                    () -> EntityType.Builder.of(AhagrioqEntity::new, MobCategory.CREATURE).sized(1f,1f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "ahagrioq").toString()));
    public static final RegistryObject<EntityType<EmabriEntity>> EMABRI =
            ENTITY_TYPES.register("emabri",
                    () -> EntityType.Builder.of(EmabriEntity::new, MobCategory.CREATURE).sized(0.4f,0.3f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "emabri").toString()));
    public static final RegistryObject<EntityType<IvekrocEntity>> IVEKROC =
            ENTITY_TYPES.register("ivekroc",
                    () -> EntityType.Builder.of(IvekrocEntity::new, MobCategory.CREATURE).sized(1f,1f)
                            .build(new ResourceLocation(Nomsterz.MOD_ID, "ivekroc").toString()));


    public static final RegistryObject<EntityType<GhogaSpitProjectile>> GHOGA_SPIT_PROJECTILE = ENTITY_TYPES.register("ghoga_spit_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<GhogaSpitProjectile>)
                    GhogaSpitProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("ghoga_spit_projectile"));
    public static final RegistryObject<EntityType<RoharkQuillProjectile>> ROHARK_QUILL_PROJECTILE = ENTITY_TYPES.register("rohark_quill_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<RoharkQuillProjectile>)
                    RoharkQuillProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("rohark_quill_projectile"));
    public static void register(IEventBus bus){
        ENTITY_TYPES.register(bus);
    }
}
