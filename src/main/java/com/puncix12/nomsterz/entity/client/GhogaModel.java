package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.GhogaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhogaModel extends AnimatedGeoModel<GhogaEntity> {
    @Override
    public ResourceLocation getModelResource(GhogaEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/ghoga.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GhogaEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ghoga.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GhogaEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/ghoga.animation.json");
    }
}
