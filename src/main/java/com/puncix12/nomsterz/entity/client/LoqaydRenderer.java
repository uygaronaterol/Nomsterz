package com.puncix12.nomsterz.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.GhogaEntity;
import com.puncix12.nomsterz.entity.custom.KashisosEntity;
import com.puncix12.nomsterz.entity.custom.LoqaydEntity;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LoqaydRenderer extends GeoEntityRenderer<LoqaydEntity> {
    public LoqaydRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LoqaydModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(LoqaydEntity instance) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/loqayd.png");
    }

    @Override
    public RenderType getRenderType(LoqaydEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        if(animatable.isBaby())
            stack.scale(0.4f,0.4f,0.4f);
        else
            stack.scale(1f,1f,1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
