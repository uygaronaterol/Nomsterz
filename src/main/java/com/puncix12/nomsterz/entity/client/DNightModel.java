package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.DNightEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DNightModel extends AnimatedGeoModel<DNightEntity> {
    @Override
    public ResourceLocation getModelResource(DNightEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/dnight.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DNightEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/dnight.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DNightEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/dnight.animation.json");
    }
}
