package com.puncix12.nomsterz.block;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.custom.DhirtaCropBlock;
import com.puncix12.nomsterz.block.custom.NomsterCraftingTableBlock;
import com.puncix12.nomsterz.item.ModCreativeModeTab;
import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
    public static final RegistryObject<Block> NOMSTER_CRAFTING_TABLE =
            registerBlock( "nomster_crafting_table", () -> new NomsterCraftingTableBlock(BlockBehaviour.Properties.of(Material.WOOD)
                            .noOcclusion().explosionResistance(2)), ModCreativeModeTab.NOMSTERZ_TAB);



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
