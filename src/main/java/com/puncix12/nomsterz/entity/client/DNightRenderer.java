package com.puncix12.nomsterz.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.DNightEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEntity;
import com.puncix12.nomsterz.entity.custom.EmabriEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DNightRenderer extends GeoEntityRenderer<DNightEntity> {
    public DNightRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DNightModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(DNightEntity instance) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/dnight.png");
    }

    @Override
    public RenderType getRenderType(DNightEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        if(animatable.isBaby())
            stack.scale(0.3f,0.3f,0.3f);
        else
            stack.scale(1f,1f,1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
