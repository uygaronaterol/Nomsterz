package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.EmabriEntity;
import com.puncix12.nomsterz.entity.custom.FerrkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FerrkerModel extends AnimatedGeoModel<FerrkerEntity> {
    @Override
    public ResourceLocation getModelResource(FerrkerEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/ferrker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FerrkerEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ferrker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FerrkerEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/ferrker.animation.json");
    }
}
