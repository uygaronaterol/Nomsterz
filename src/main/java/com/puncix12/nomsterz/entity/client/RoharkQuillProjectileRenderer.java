package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.GhogaSpitProjectile;
import com.puncix12.nomsterz.entity.custom.RoharkQuillProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RoharkQuillProjectileRenderer extends ArrowRenderer<RoharkQuillProjectile> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/rohark_quill.png");

    public RoharkQuillProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(RoharkQuillProjectile arrow) {
        return TEXTURE;
    }
}
