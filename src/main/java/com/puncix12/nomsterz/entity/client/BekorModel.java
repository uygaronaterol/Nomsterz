package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.BekorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BekorModel extends AnimatedGeoModel<BekorEntity> {
    @Override
    public ResourceLocation getModelResource(BekorEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/bekor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BekorEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/bekor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BekorEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/bekor.animation.json");
    }
}
