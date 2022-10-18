package com.puncix12.nomsterz.event;


import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.entity.custom.*;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
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

                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 25),
                        stack, 10, 2, 0.02F));
                ItemStack stack5 = new ItemStack(ModItems.ILGROSU_SEED.get(), 1);
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 25),
                        stack5, 10, 2, 0.02F));

                ItemStack stack1 = new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 1);
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_SWERDARM_MEAT.get(), 1),
                        stack1, 10, 2, 0.02F));

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_NYANGA_MEAT.get(), 2),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_PELLATT_MEAT.get(), 4),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_YONSI_MEAT.get(), 3),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_NATSHAI_MEAT.get(), 5),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_GHOGA_MEAT.get(), 4),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_YONSI_MEAT.get(), 2),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_PELLATT_MEAT.get(), 4),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_KASHISOS_MEAT.get(), 4),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_OHANUSH_MEAT.get(), 2),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_ROHARK_MEAT.get(), 4),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_EMABRI_MEAT.get(), 10),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_IVEKROC_MEAT.get(), 3),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.COOKED_AHAGRIOQ_MEAT.get(), 3),
                        stack1, 10, 2, 0.02F));
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModBlocks.LAUS_LOG.get(), 19),
                        stack1, 10, 2, 0.02F));

                ItemStack stack4 = new ItemStack(ModBlocks.LAUS_SAPLING.get().asItem(), 1);
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 15),
                        stack4, 10, 5, 0.02F));

                ItemStack stack2 = new ItemStack(Items.EMERALD, 2);
                ItemStack stack3 = new ItemStack(Items.EMERALD, 3);

                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 35),
                        stack2, 10, 5, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 50),
                        stack3, 10, 5, 0.02F));
                ItemStack stack6 = new ItemStack(ModBlocks.FARMERS_SAPLING.get().asItem(), 1);
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 64),
                        stack6, 10, 5, 0.02F));
                ItemStack stack7 = new ItemStack(ModBlocks.LAUS_SAPLING.get().asItem(), 1);
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.NOMSTER_ESSENCE.get(), 34),
                        stack7, 10, 5, 0.02F));
                ItemStack stack8 = new ItemStack(ModItems.NOMSTER_SWORD_HANDLE.get(), 1);

                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 52),
                        stack8, 2, 5, 0.02F));
            }
        }
    }

    @Mod.EventBusSubscriber( modid = Nomsterz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.NATSHAI.get(), NatshaiEntity.setAttributes());
            event.put(ModEntityTypes.NYANGA.get(), NyangaEntity.setAttributes());
            event.put(ModEntityTypes.SWERDARM.get(), SwerdarmEntity.setAttributes());
            event.put(ModEntityTypes.PELLATT.get(), PellattEntity.setAttributes());
            event.put(ModEntityTypes.GHOGA.get(), GhogaEntity.setAttributes());
            event.put(ModEntityTypes.YONSI.get(), YonsiEntity.setAttributes());
            event.put(ModEntityTypes.ROHARK.get(), RoharkEntity.setAttributes());
            event.put(ModEntityTypes.KASHISOS.get(), KashisosEntity.setAttributes());
            event.put(ModEntityTypes.OHANUSH.get(), OhanushEntity.setAttributes());
            event.put(ModEntityTypes.AHAGRIOQ.get(), AhagrioqEntity.setAttributes());
            event.put(ModEntityTypes.EMABRI.get(), EmabriEntity.setAttributes());
            event.put(ModEntityTypes.IVEKROC.get(), IvekrocEntity.setAttributes());
            event.put(ModEntityTypes.DERRMUES.get(), DerrmuesEntity.setAttributes());
            event.put(ModEntityTypes.OSIPITI.get(), OsipitiEntity.setAttributes());
            event.put(ModEntityTypes.PIARA.get(), PiaraEntity.setAttributes());
            event.put(ModEntityTypes.BEKOR.get(), BekorEntity.setAttributes());
            event.put(ModEntityTypes.WAPAULENDO.get(), WapaulendoEntity.setAttributes());
            event.put(ModEntityTypes.AGWO.get(), AgwoEntity.setAttributes());

            event.put(ModEntityTypes.BEKOR_EGG.get(), BekorEggEntity.setAttributes());
            event.put(ModEntityTypes.DERRMUES_EGG.get(), DerrmuesEggEntity.setAttributes());

        }
    }
}
