package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.GhogaSpitProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GhogaSpitProjectileRenderer extends ArrowRenderer<GhogaSpitProjectile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ghoga_spit.png");

    public GhogaSpitProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(GhogaSpitProjectile arrow) {
        return TEXTURE;
    }
}
