package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Nomsterz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.DNIGHT_PROJECTILE.get(), DNightProjectileRenderer::new);
        EntityRenderers.register(ModEntityTypes.BEKOR_PROJECTILE.get(), BekorProjectileRenderer::new);
        EntityRenderers.register(ModEntityTypes.GHOGA_SPIT_PROJECTILE.get(), GhogaSpitProjectileRenderer::new);
        EntityRenderers.register(ModEntityTypes.CHOLENKA_PROJECTILE.get(), CholenkaProjectileRenderer::new);

    }
}