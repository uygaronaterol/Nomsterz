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


    public static final RegistryObject<PlacedFeature> DESERT_BLOSSOM_PLACED = PLACED_FEATURES.register("desert_blossom_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DESERT_BLOSSOM.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(1),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));


    public static final RegistryObject<PlacedFeature> LAUS_CHECKED = PLACED_FEATURES.register("laus_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.LAUS.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.LAUS_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> LAUS_PLACED = PLACED_FEATURES.register("laus_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LAUS_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1))));


    public static final RegistryObject<PlacedFeature> FARMERS_CHECKED = PLACED_FEATURES.register("farmers_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.FARMERS.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.FARMERS_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> FARMERS_PLACED = PLACED_FEATURES.register("farmers_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FARMERS_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1))));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}