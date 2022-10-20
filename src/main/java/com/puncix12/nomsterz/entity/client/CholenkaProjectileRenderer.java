package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.CholenkaProjectile;
import com.puncix12.nomsterz.entity.custom.GhogaSpitProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CholenkaProjectileRenderer extends ArrowRenderer<CholenkaProjectile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/cholenka_piece.png");

    public CholenkaProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(CholenkaProjectile arrow) {
        return TEXTURE;
    }
}
