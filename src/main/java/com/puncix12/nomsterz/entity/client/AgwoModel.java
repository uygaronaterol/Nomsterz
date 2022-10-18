package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AgwoEntity;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AgwoModel extends AnimatedGeoModel<AgwoEntity> {
    @Override
    public ResourceLocation getModelResource(AgwoEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/agwo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AgwoEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/agwo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AgwoEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/agwo.animation.json");
    }
}
