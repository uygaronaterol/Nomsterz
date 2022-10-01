package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.GhogaEntity;
import com.puncix12.nomsterz.entity.custom.RoharkEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RoharkModel extends AnimatedGeoModel<RoharkEntity> {
    @Override
    public ResourceLocation getModelResource(RoharkEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/rohark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RoharkEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/rohark.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RoharkEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/rohark.animation.json");
    }
}
