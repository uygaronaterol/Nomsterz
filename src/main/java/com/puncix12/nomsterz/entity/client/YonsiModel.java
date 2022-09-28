package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.PellattEntity;
import com.puncix12.nomsterz.entity.custom.YonsiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YonsiModel extends AnimatedGeoModel<YonsiEntity> {
    @Override
    public ResourceLocation getModelResource(YonsiEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/yonsi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(YonsiEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/yonsi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(YonsiEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/yonsi.animation.json");
    }
}
