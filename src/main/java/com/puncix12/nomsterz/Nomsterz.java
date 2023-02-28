package com.puncix12.nomsterz;

import com.mojang.logging.LogUtils;
import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.block.entity.ModBlockEntities;
import com.puncix12.nomsterz.enchantment.ModEnchantments;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.entity.client.*;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.recipe.ModRecipes;
import com.puncix12.nomsterz.screen.ModMenuTypes;
import com.puncix12.nomsterz.screen.NomsterCraftingTableScreen;
import com.puncix12.nomsterz.sound.ModSounds;
import com.puncix12.nomsterz.villager.ModVillagers;
import com.puncix12.nomsterz.world.biome.modifier.ModBiomeModifier;
import com.puncix12.nomsterz.world.feature.ModConfiguredFeatures;
import com.puncix12.nomsterz.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Nomsterz.MOD_ID)
public class Nomsterz
{
    public static final String MOD_ID = "nomsterz";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Nomsterz()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBiomeModifier.register(modEventBus);
        GeckoLib.initialize();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityTypes.NATSHAI.get(), NatshaiRenderer::new);
            EntityRenderers.register(ModEntityTypes.NYANGA.get(), NyangaRenderer::new);
            EntityRenderers.register(ModEntityTypes.SWERDARM.get(), SwerdarmRenderer::new);
            EntityRenderers.register(ModEntityTypes.PELLATT.get(), PellattRenderer::new);
            EntityRenderers.register(ModEntityTypes.GHOGA.get(), GhogaRenderer::new);
            EntityRenderers.register(ModEntityTypes.YONSI.get(), YonsiRenderer::new);
            EntityRenderers.register(ModEntityTypes.ROHARK.get(), RoharkRenderer::new);
            EntityRenderers.register(ModEntityTypes.KASHISOS.get(), KashisosRenderer::new);
            EntityRenderers.register(ModEntityTypes.OHANUSH.get(), OhanushRenderer::new);
            EntityRenderers.register(ModEntityTypes.AHAGRIOQ.get(), AhagrioqRenderer::new);
            EntityRenderers.register(ModEntityTypes.EMABRI.get(), EmabriRenderer::new);
            EntityRenderers.register(ModEntityTypes.IVEKROC.get(), IvekrocRenderer::new);
            EntityRenderers.register(ModEntityTypes.DERRMUES.get(), DerrmuesRenderer::new);
            EntityRenderers.register(ModEntityTypes.OSIPITI.get(), OsipitiRenderer::new);
            EntityRenderers.register(ModEntityTypes.PIARA.get(), PiaraRenderer::new);
            EntityRenderers.register(ModEntityTypes.BEKOR.get(), BekorRenderer::new);
            EntityRenderers.register(ModEntityTypes.WAPAULENDO.get(), WapaulendoRenderer::new);
            EntityRenderers.register(ModEntityTypes.AGWO.get(), AgwoRenderer::new);
            EntityRenderers.register(ModEntityTypes.CHOLENKA.get(), CholenkaRenderer::new);
            EntityRenderers.register(ModEntityTypes.LOQAYD.get(), LoqaydRenderer::new);
            EntityRenderers.register(ModEntityTypes.FERRKER.get(), FerrkerRenderer::new);
            EntityRenderers.register(ModEntityTypes.DNIGHT.get(), DNightRenderer::new);

            EntityRenderers.register(ModEntityTypes.DERRMUES_EGG.get(), DerrmuesEggRenderer::new);
            EntityRenderers.register(ModEntityTypes.BEKOR_EGG.get(), BekorEggRenderer::new);
            EntityRenderers.register(ModEntityTypes.DNIGHT_EGG.get(), DNightEggRenderer::new);


            MenuScreens.register(ModMenuTypes.NOMSTER_CRAFTING_TABLE_MENU.get(), NomsterCraftingTableScreen::new);

        }
    }
}
