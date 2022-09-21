package com.puncix12.nomsterz.item;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.custom.NomsterCommander;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Nomsterz.MOD_ID);

    public static final RegistryObject<Item> NATSHAI_SKIN = ITEMS.register("natshai_skin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> MEAT_PACKAGE = ITEMS.register("meat_package",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.MEAT_PACKAGE)));
    public static final RegistryObject<Item> NATSHAI_SPAWN_EGG = ITEMS.register("natshai_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NATSHAI,0x066606,0x0c400c
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> NOMSTER_COMMANDER = ITEMS.register("nomster_commander",
            () -> new NomsterCommander(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> RAW_NATSHAI_MEAT = ITEMS.register("raw_natshai_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_NATSHAI_MEAT)));
    public static final RegistryObject<Item> COOKED_NATSHAI_MEAT = ITEMS.register("cooked_natshai_meat",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_NATSHAI_MEAT)));
    public static final RegistryObject<Item> DHIRTA_SEED = ITEMS.register("dhirta_seed",
            () -> new ItemNameBlockItem(ModBlocks.DHIRTA_CROP.get(),new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> DHIRTA = ITEMS.register("dhirta",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
