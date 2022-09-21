package com.puncix12.nomsterz.entity;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
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
    public static void register(IEventBus bus){
        ENTITY_TYPES.register(bus);
    }
}
