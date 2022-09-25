package com.puncix12.nomsterz.event;


import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import com.puncix12.nomsterz.entity.custom.NyangaEntity;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber( modid = Nomsterz.MOD_ID)
    public static class ForgeEvents{
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {

            if (event.getType() == ModVillagers.NOMSTER_EXPERT.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.DHIRTA_SEED.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 25),
                        stack, 10, 8, 0.02F));
            }
        }
    }

    @Mod.EventBusSubscriber( modid = Nomsterz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.NATSHAI.get(), NatshaiEntity.setAttributes());
            event.put(ModEntityTypes.NYANGA.get(), NyangaEntity.setAttributes());
            event.put(ModEntityTypes.SWERDARM.get(), NyangaEntity.setAttributes());

        }
    }
}
