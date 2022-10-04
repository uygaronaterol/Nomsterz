package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AhagrioqModel extends AnimatedGeoModel<AhagrioqEntity> {
    @Override
    public ResourceLocation getModelResource(AhagrioqEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/ahagrioq.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AhagrioqEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ahagrioq.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AhagrioqEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/ahagrioq.animation.json");
    }
}
