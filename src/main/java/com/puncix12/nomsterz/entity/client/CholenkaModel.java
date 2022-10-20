package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.CholenkaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CholenkaModel extends AnimatedGeoModel<CholenkaEntity> {
    @Override
    public ResourceLocation getModelResource(CholenkaEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/cholenka.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CholenkaEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/cholenka.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CholenkaEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/cholenka.animation.json");
    }
}
