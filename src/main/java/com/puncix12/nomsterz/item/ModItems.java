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
