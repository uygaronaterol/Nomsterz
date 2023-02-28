package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DNightEggModel extends AnimatedGeoModel<DNightEggEntity> {
    @Override
    public ResourceLocation getModelResource(DNightEggEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/dnight_egg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DNightEggEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/dnight_egg.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DNightEggEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/dnight_egg.animation.json");
    }
}
