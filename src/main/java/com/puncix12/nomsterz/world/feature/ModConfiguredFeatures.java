package com.puncix12.nomsterz.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Nomsterz.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> LAUS =
            CONFIGURED_FEATURES.register("laus", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.LAUS_LOG.get()),
                            new MegaJungleTrunkPlacer(12, 6, 15),
                            BlockStateProvider.simple(ModBlocks.LAUS_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                            new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LAUS_SPAWN =
            CONFIGURED_FEATURES.register("laus_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.LAUS_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.LAUS_CHECKED.getHolder().get())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> FARMERS =
            CONFIGURED_FEATURES.register("farmers", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.FARMERS_LOG.get()),
                            new MegaJungleTrunkPlacer(3, 1, 1),
                            BlockStateProvider.simple(ModBlocks.FARMERS_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                            new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> FARMERS_SPAWN =
            CONFIGURED_FEATURES.register("farmers_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.FARMERS_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.FARMERS_CHECKED.getHolder().get())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DESERT_BLOSSOM = CONFIGURED_FEATURES.register("desert_blossom",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DESERT_BLOSSOM.get()))))));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}