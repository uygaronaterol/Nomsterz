package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.BekorProjectile;
import com.puncix12.nomsterz.entity.custom.GhogaSpitProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BekorProjectileRenderer extends ArrowRenderer<BekorProjectile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ghoga_spit.png");

    public BekorProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(BekorProjectile arrow) {
        return TEXTURE;
    }
}
