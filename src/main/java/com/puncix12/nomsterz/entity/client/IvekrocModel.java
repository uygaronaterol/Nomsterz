package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.IvekrocEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IvekrocModel extends AnimatedGeoModel<IvekrocEntity> {
    @Override
    public ResourceLocation getModelResource(IvekrocEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/ivekroc.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IvekrocEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ivekroc.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IvekrocEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/ivekroc.animation.json");
    }
}
