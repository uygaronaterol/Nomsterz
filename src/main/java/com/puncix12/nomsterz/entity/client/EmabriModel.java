package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.EmabriEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EmabriModel extends AnimatedGeoModel<EmabriEntity> {
    @Override
    public ResourceLocation getModelResource(EmabriEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/emabri.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EmabriEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/emabri.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EmabriEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/emabri.animation.json");
    }
}
