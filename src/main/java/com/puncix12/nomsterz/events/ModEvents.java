package com.puncix12.nomsterz.events;


import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber( modid = Nomsterz.MOD_ID)
    public static class ForgeEvents{

    }

    @Mod.EventBusSubscriber( modid = Nomsterz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.NATSHAI.get(), NatshaiEntity.setAttributes());
        }
    }
}
