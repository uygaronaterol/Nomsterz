package com.puncix12.nomsterz.villager;

import com.google.common.collect.ImmutableSet;
import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Nomsterz.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Nomsterz.MOD_ID);

    public static final RegistryObject<PoiType> NOMSTER_CRAFTING_TABLE_POI =
            POI_TYPES.register("nomster_crafting_table_poi", () ->
                    new PoiType(ImmutableSet.copyOf(ModBlocks.NOMSTER_CRAFTING_TABLE.get().getStateDefinition().getPossibleStates()),
                            1,1));
    public static final RegistryObject<VillagerProfession> NOMSTER_EXPERT =
            VILLAGER_PROFESSIONS.register("nomster_expert", () -> new VillagerProfession("nomster_expert",
                    x -> x.get() == NOMSTER_CRAFTING_TABLE_POI.get(),
                        x -> x.get() == NOMSTER_CRAFTING_TABLE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_CLERIC));


    public static void registerPOIs(){
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).
                    invoke(null, NOMSTER_CRAFTING_TABLE_POI.get());
        }catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }
    public static void register(IEventBus bus){
        POI_TYPES.register(bus);
        VILLAGER_PROFESSIONS.register(bus);
    }
}
