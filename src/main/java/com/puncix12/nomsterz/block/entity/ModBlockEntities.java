package com.puncix12.nomsterz.block.entity;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Nomsterz.MOD_ID);

    public static final RegistryObject<BlockEntityType<NomsterCraftingTableBlockEntity>> NOMSTER_CRAFTING_TABLE =
            BLOCK_ENTITIES.register("nomster_crafting_table",
                    () -> BlockEntityType.Builder.of(NomsterCraftingTableBlockEntity::new, ModBlocks.NOMSTER_CRAFTING_TABLE.get())
                            .build(null));

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
