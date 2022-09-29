package com.puncix12.nomsterz.world.feature;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Nomsterz.MOD_ID);





    public static final RegistryObject<PlacedFeature> LAUS_CHECKED = PLACED_FEATURES.register("laus_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.LAUS.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.LAUS_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> LAUS_PLACED = PLACED_FEATURES.register("laus_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LAUS_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1))));



    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}