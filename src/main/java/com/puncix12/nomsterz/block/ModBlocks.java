package com.puncix12.nomsterz.block;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.custom.*;
import com.puncix12.nomsterz.item.ModCreativeModeTab;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.world.feature.tree.FarmersTreeGrower;
import com.puncix12.nomsterz.world.feature.tree.LausTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Nomsterz.MOD_ID);
    public static final RegistryObject<Block> DHIRTA_CROP =
            BLOCKS.register( "dhirta_crop", () -> new DhirtaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> ILGROSU_CROP =
            BLOCKS.register( "ilgrosu_crop", () -> new IlgrosuCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> NOMSTER_CRAFTING_TABLE =
            registerBlock( "nomster_crafting_table", () -> new NomsterCraftingTableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                            .noOcclusion().explosionResistance(2)), ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> SUMMONING_ALTAR =
            registerBlock( "summoning_altar", () -> new SummoningAltarBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .noOcclusion().strength(10,100)), ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> LAUS_LOG = registerBlock("laus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> LAUS_WOOD = registerBlock("laus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> STRIPPED_LAUS_LOG = registerBlock("stripped_laus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> STRIPPED_LAUS_WOOD = registerBlock("stripped_laus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> LAUS_PLANKS = registerBlock("laus_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> LAUS_LEAVES = registerBlock("laus_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> LAUS_SAPLING = registerBlock("laus_sapling",
            () -> new SaplingBlock(new LausTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> FARMERS_LOG = registerBlock("farmers_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> FARMERS_WOOD = registerBlock("farmers_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> STRIPPED_FARMERS_LOG = registerBlock("stripped_farmers_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> STRIPPED_FARMERS_WOOD = registerBlock("stripped_farmers_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> FARMERS_PLANKS = registerBlock("farmers_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.NOMSTERZ_TAB);
    public static final RegistryObject<Block> FARMERS_LEAVES = registerBlock("farmers_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> FARMERS_SAPLING = registerBlock("farmers_sapling",
            () -> new SaplingBlock(new FarmersTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.NOMSTERZ_TAB);

    public static final RegistryObject<Block> DESERT_BLOSSOM = registerBlock("desert_blossom",
            () -> new FlowerBlock(MobEffects.BAD_OMEN,30,BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)), ModCreativeModeTab.NOMSTERZ_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem( String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
