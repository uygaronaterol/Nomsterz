package com.puncix12.nomsterz.item;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Nomsterz.MOD_ID);

    //Nomster Drops
    public static final RegistryObject<Item> NATSHAI_SKIN = ITEMS.register("natshai_skin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> NOMSTER_ESSENCE = ITEMS.register("nomster_essence",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> NYANGA_ANTLER = ITEMS.register("nyanga_antler",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> SWERDARM_SWORD_PIECE = ITEMS.register("swerdarm_sword_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> GHOGA_SPIT = ITEMS.register("ghoga_spit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> PELLATT_BEAK = ITEMS.register("pellatt_beak",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> YONSI_CLAW = ITEMS.register("yonsi_claw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));

    //Spawn Eggs
    public static final RegistryObject<Item> NATSHAI_SPAWN_EGG = ITEMS.register("natshai_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NATSHAI,0x066606,0x0c400c
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> NYANGA_SPAWN_EGG = ITEMS.register("nyanga_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NYANGA,0x9486f,0xf0e5d1
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> SWERDARM_SPAWN_EGG = ITEMS.register("swerdarm_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SWERDARM,0x647725,0x9cb841
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> PELLATT_SPAWN_EGG = ITEMS.register("pellatt_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PELLATT,0x711f5d,0x98297d
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> GHOGA_SPAWN_EGG = ITEMS.register("ghoga_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GHOGA,0x6c5e44,0xb8ac8e
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> YONSI_SPAWN_EGG = ITEMS.register("yonsi_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.YONSI,0x065f1b,0x0a7c25
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));

    //Nomster items
    public static final RegistryObject<Item> NOMSTER_COMMANDER = ITEMS.register("nomster_commander",
            () -> new NomsterCommanderItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> WARPED_SWORD = ITEMS.register("warped_sword",
            () -> new WarpedSwordItem(Tiers.NETHERITE, 6,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));

    //Foods
    public static final RegistryObject<Item> RAW_NATSHAI_MEAT = ITEMS.register("raw_natshai_meat",
            () -> new RawNatshaiMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_NATSHAI_MEAT)));
    public static final RegistryObject<Item> COOKED_NATSHAI_MEAT = ITEMS.register("cooked_natshai_meat",
            () -> new CookedNatshaiMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_NATSHAI_MEAT)));
    public static final RegistryObject<Item> RAW_NYANGA_MEAT = ITEMS.register("raw_nyanga_meat",
            () -> new RawNyangaMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_NYANGA_MEAT)));
    public static final RegistryObject<Item> COOKED_NYANGA_MEAT = ITEMS.register("cooked_nyanga_meat",
            () -> new CookedNyangaMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_NYANGA_MEAT)));
    public static final RegistryObject<Item> RAW_SWERDARM_MEAT = ITEMS.register("raw_swerdarm_meat",
            () -> new RawSwerdarmMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_SWERDARM_MEAT)));
    public static final RegistryObject<Item> COOKED_SWERDARM_MEAT = ITEMS.register("cooked_swerdarm_meat",
            () -> new CookedSwerdarmMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_SWERDARM_MEAT)));
    public static final RegistryObject<Item> RAW_GHOGA_MEAT = ITEMS.register("raw_ghoga_meat",
            () -> new RawGhogaItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_GHOGA_MEAT)));
    public static final RegistryObject<Item> COOKED_GHOGA_MEAT = ITEMS.register("cooked_ghoga_meat",
            () -> new CookedGhogaItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_GHOGA_MEAT)));
    public static final RegistryObject<Item> RAW_YONSI_MEAT = ITEMS.register("raw_yonsi_meat",
            () -> new RawYonsiItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_YONSI_MEAT)));
    public static final RegistryObject<Item> COOKED_YONSI_MEAT = ITEMS.register("cooked_yonsi_meat",
            () -> new CookedYonsiItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_YONSI_MEAT)));
    public static final RegistryObject<Item> RAW_PELLATT_MEAT = ITEMS.register("raw_pellatt_meat",
            () -> new RawPellattItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_PELLATT_MEAT)));
    public static final RegistryObject<Item> COOKED_PELLATT_MEAT = ITEMS.register("cooked_pellatt_meat",
            () -> new CookedPellattItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_PELLATT_MEAT)));


    //Nomster foods
    public static final RegistryObject<Item> MEAT_PACKAGE = ITEMS.register("meat_package",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.MEAT_PACKAGE)));
    public static final RegistryObject<Item> DHIRTA = ITEMS.register("dhirta",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.DHIRTA)));

    //Crop
    public static final RegistryObject<Item> DHIRTA_SEED = ITEMS.register("dhirta_seed",
            () -> new ItemNameBlockItem(ModBlocks.DHIRTA_CROP.get(),new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));



    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
