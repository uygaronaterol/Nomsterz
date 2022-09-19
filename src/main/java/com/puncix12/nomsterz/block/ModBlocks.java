package com.puncix12.nomsterz.block;

import com.puncix12.nomsterz.Nomsterz;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Nomsterz.MOD_ID);

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
