package com.puncix12.nomsterz.item;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ShieldItem;
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
    public static final RegistryObject<Item> ROHARK_QUILL = ITEMS.register("rohark_quill",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> OHANUSH_HAND = ITEMS.register("ohanush_hand",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> KASHISOS_HEAD_PIECE = ITEMS.register("kashisos_head_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> AHAGRIOQ_FIN = ITEMS.register("ahagrioq_fin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> EMABRI_SHELL = ITEMS.register("emabri_shell",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> IVEKROC_HORN = ITEMS.register("ivekroc_horn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> DERRMUES_TOOTH = ITEMS.register("derrmues_tooth",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> OSIPITI_TREE = ITEMS.register("osipiti_tree",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> PIARA_HEAD = ITEMS.register("piara_head",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> BEKOR_EYE_PIECE = ITEMS.register("bekor_eye_piece",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> WAPAULENDO_TAIL = ITEMS.register("wapaulendo_tail",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> AGWO_FANG = ITEMS.register("agwo_fang",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> CHOLENKA_PIECE = ITEMS.register("cholenka_piece",
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
    public static final RegistryObject<Item> ROHARK_SPAWN_EGG = ITEMS.register("rohark_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ROHARK,0x2f200f,0xd1c6b1
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> KASHISOS_SPAWN_EGG = ITEMS.register("kashisos_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KASHISOS,0x1e3e26,0xa8b9ab
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> OHANUSH_SPAWN_EGG = ITEMS.register("ohanush_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.OHANUSH,0x1c4401,0X85bb1f
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> AHAGRIOQ_SPAWN_EGG = ITEMS.register("ahagrioq_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.AHAGRIOQ,0xde7979,0x9c4b4b
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> EMABRI_SPAWN_EGG = ITEMS.register("emabri_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.EMABRI,0x53a34d,0xafff90
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> IVEKROC_SPAWN_EGG = ITEMS.register("ivekroc_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.IVEKROC,0x17445c,0x2dccff
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> DERRMUES_SPAWN_EGG = ITEMS.register("derrmues_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DERRMUES,0x3d483b,0x133716
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> OSIPITI_SPAWN_EGG = ITEMS.register("osipiti_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.OSIPITI,0x886461,0x4f6d20
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> PIARA_SPAWN_EGG = ITEMS.register("piara_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PIARA,0x6d8836,0x3b5612
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> BEKOR_SPAWN_EGG = ITEMS.register("bekor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEKOR,0x2a2f25,0x4fc353
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> WAPAULENDO_SPAWN_EGG = ITEMS.register("wapaulendo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.WAPAULENDO,0xd5c496,0xe3dbb0
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> AGWO_SPAWN_EGG = ITEMS.register("agwo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.AGWO,0xedebcb6,0xd5c496
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> CHOLENKA_SPAWN_EGG = ITEMS.register("cholenka_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHOLENKA,0x50b9ff,0x2d5173
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));

    public static final RegistryObject<Item> DERRMUES_EGG_SPAWN_EGG = ITEMS.register("derrmues_egg_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DERRMUES_EGG,0x3d483b,0x133716
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> BEKOR_EGG_SPAWN_EGG = ITEMS.register("bekor_egg_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEKOR_EGG,0x2a2f25,0x4fc353
                    ,new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));


    //Nomster items
    public static final RegistryObject<Item> NOMSTER_COMMANDER = ITEMS.register("nomster_commander",
            () -> new NomsterCommanderItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> WARPED_SWORD = ITEMS.register("warped_sword",
            () -> new WarpedSwordItem(Tiers.NETHERITE, 6,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> LAUS_RING = ITEMS.register("laus_ring",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(16)));
    public static final RegistryObject<Item> IRON_LAUS_RING = ITEMS.register("iron_laus_ring",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(16)));
    public static final RegistryObject<Item> RING_OF_RESISTANCE = ITEMS.register("ring_of_resistance",
            () -> new RingOfResistanceItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> RING_OF_STRENGTH = ITEMS.register("ring_of_strength",
            () -> new RingOfStrengthItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> RING_OF_ENLIGHTENMENT = ITEMS.register("ring_of_enlightenment",
            () -> new RingOfEnlightenmentItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SHIELD_OF_REGENERATION = ITEMS.register("shield_of_regeneration",
            () -> new ShieldOfRegenerationItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> LAUS_SHIELD = ITEMS.register("laus_shield",
            () -> new ShieldItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1).durability(800)));
    public static final RegistryObject<Item> TRIDENT_FROM_DEPTHS = ITEMS.register("trident_from_depths",
            () -> new TridentFromDepthsItem(Tiers.NETHERITE, 6,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> DERRMUES_SUMMONING_KEY = ITEMS.register("derrmues_summoning_key",
            () -> new DerrmuesSummoningKeyItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> DERRMUES_EGG = ITEMS.register("derrmues_egg",
            () -> new DerrmuesEggItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BEKOR_EGG = ITEMS.register("bekor_egg",
            () -> new BekorEggItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BEKOR_SUMMONING_KEY = ITEMS.register("bekor_summoning_key",
            () -> new BekorSummoningKeyItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));
    public static final RegistryObject<Item> NOMSTER_SWORD_HANDLE = ITEMS.register("nomster_sword_handle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> NOMSTER_SWORD = ITEMS.register("nomster_sword",
            () -> new NomsterSwordItem(Tiers.NETHERITE, 2,-2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).stacksTo(1)));

    //Foods
    public static final RegistryObject<Item> RAW_NATSHAI_MEAT = ITEMS.register("raw_natshai_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_NATSHAI_MEAT)));
    public static final RegistryObject<Item> COOKED_NATSHAI_MEAT = ITEMS.register("cooked_natshai_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_NATSHAI_MEAT)));
    public static final RegistryObject<Item> RAW_NYANGA_MEAT = ITEMS.register("raw_nyanga_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_NYANGA_MEAT)));
    public static final RegistryObject<Item> COOKED_NYANGA_MEAT = ITEMS.register("cooked_nyanga_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_NYANGA_MEAT)));
    public static final RegistryObject<Item> RAW_SWERDARM_MEAT = ITEMS.register("raw_swerdarm_meat",
            () -> new HazardousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_SWERDARM_MEAT)));
    public static final RegistryObject<Item> COOKED_SWERDARM_MEAT = ITEMS.register("cooked_swerdarm_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_SWERDARM_MEAT)));
    public static final RegistryObject<Item> RAW_GHOGA_MEAT = ITEMS.register("raw_ghoga_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_GHOGA_MEAT)));
    public static final RegistryObject<Item> COOKED_GHOGA_MEAT = ITEMS.register("cooked_ghoga_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_GHOGA_MEAT)));
    public static final RegistryObject<Item> RAW_YONSI_MEAT = ITEMS.register("raw_yonsi_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_YONSI_MEAT)));
    public static final RegistryObject<Item> COOKED_YONSI_MEAT = ITEMS.register("cooked_yonsi_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_YONSI_MEAT)));
    public static final RegistryObject<Item> RAW_PELLATT_MEAT = ITEMS.register("raw_pellatt_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_PELLATT_MEAT)));
    public static final RegistryObject<Item> COOKED_PELLATT_MEAT = ITEMS.register("cooked_pellatt_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_PELLATT_MEAT)));
    public static final RegistryObject<Item> RAW_OHANUSH_MEAT = ITEMS.register("raw_ohanush_meat",
            () -> new HazardousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_OHANUSH_MEAT)));
    public static final RegistryObject<Item> COOKED_OHANUSH_MEAT = ITEMS.register("cooked_ohanush_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_OHANUSH_MEAT)));
    public static final RegistryObject<Item> RAW_KASHISOS_MEAT = ITEMS.register("raw_kashisos_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_KASHISOS_MEAT)));
    public static final RegistryObject<Item> COOKED_KASHISOS_MEAT = ITEMS.register("cooked_kashisos_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_KASHISOS_MEAT)));
    public static final RegistryObject<Item> RAW_ROHARK_MEAT = ITEMS.register("raw_rohark_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_ROHARK_MEAT)));
    public static final RegistryObject<Item> COOKED_ROHARK_MEAT = ITEMS.register("cooked_rohark_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_ROHARK_MEAT)));
    public static final RegistryObject<Item> RAW_IVEKROC_MEAT = ITEMS.register("raw_ivekroc_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_IVEKROC_MEAT)));
    public static final RegistryObject<Item> COOKED_IVEKROC_MEAT = ITEMS.register("cooked_ivekroc_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_IVEKROC_MEAT)));
    public static final RegistryObject<Item> RAW_EMABRI_MEAT = ITEMS.register("raw_emabri_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_EMABRI_MEAT)));
    public static final RegistryObject<Item> COOKED_EMABRI_MEAT = ITEMS.register("cooked_emabri_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_EMABRI_MEAT)));
    public static final RegistryObject<Item> RAW_AHAGRIOQ_MEAT = ITEMS.register("raw_ahagrioq_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_AHAGRIOQ_MEAT)));
    public static final RegistryObject<Item> COOKED_AHAGRIOQ_MEAT = ITEMS.register("cooked_ahagrioq_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_AHAGRIOQ_MEAT)));
    public static final RegistryObject<Item> RAW_DERRMUES_MEAT = ITEMS.register("raw_derrmues_meat",
            () -> new HazardousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_DERRMUES_MEAT)));
    public static final RegistryObject<Item> COOKED_DERRMUES_MEAT = ITEMS.register("cooked_derrmues_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_DERRMUES_MEAT)));
    public static final RegistryObject<Item> RAW_PIARA_MEAT = ITEMS.register("raw_piara_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_PIARA_MEAT)));
    public static final RegistryObject<Item> COOKED_PIARA_MEAT = ITEMS.register("cooked_piara_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_PIARA_MEAT)));
    public static final RegistryObject<Item> RAW_OSIPITI_MEAT = ITEMS.register("raw_osipiti_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_OSIPITI_MEAT)));
    public static final RegistryObject<Item> COOKED_OSIPITI_MEAT = ITEMS.register("cooked_osipiti_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_OSIPITI_MEAT)));
    public static final RegistryObject<Item> RAW_BEKOR_MEAT = ITEMS.register("raw_bekor_meat",
            () -> new HazardousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_BEKOR_MEAT)));
    public static final RegistryObject<Item> COOKED_BEKOR_MEAT = ITEMS.register("cooked_bekor_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_BEKOR_MEAT)));
    public static final RegistryObject<Item> RAW_WAPAULENDO_MEAT = ITEMS.register("raw_wapaulendo_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_WAPAULENDO_MEAT)));
    public static final RegistryObject<Item> COOKED_WAPAULENDO_MEAT = ITEMS.register("cooked_wapaulendo_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_WAPAULENDO_MEAT)));
    public static final RegistryObject<Item> RAW_AGWO_MEAT = ITEMS.register("raw_agwo_meat",
            () -> new DangerousMeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.RAW_AGWO_MEAT)));
    public static final RegistryObject<Item> COOKED_AGWO_MEAT = ITEMS.register("cooked_agwo_meat",
            () -> new MeatItem(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.COOKED_AGWO_MEAT)));


    //Nomster foods
    public static final RegistryObject<Item> MEAT_PACKAGE = ITEMS.register("meat_package",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.MEAT_PACKAGE)));
    public static final RegistryObject<Item> DHIRTA = ITEMS.register("dhirta",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.DHIRTA)));
    public static final RegistryObject<Item> ILGROSU = ITEMS.register("ilgrosu",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB).food(ModFoods.ILGROSU)));

    //Crop
    public static final RegistryObject<Item> DHIRTA_SEED = ITEMS.register("dhirta_seed",
            () -> new ItemNameBlockItem(ModBlocks.DHIRTA_CROP.get(),new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));
    public static final RegistryObject<Item> ILGROSU_SEED = ITEMS.register("ilgrosu_seed",
            () -> new ItemNameBlockItem(ModBlocks.ILGROSU_CROP.get(),new Item.Properties().tab(ModCreativeModeTab.NOMSTERZ_TAB)));


    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
