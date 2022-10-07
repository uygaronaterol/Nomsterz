package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEggEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DerrmuesEggModel extends AnimatedGeoModel<DerrmuesEggEntity> {
    @Override
    public ResourceLocation getModelResource(DerrmuesEggEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/derrmues_egg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DerrmuesEggEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/derrmues_egg.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DerrmuesEggEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/derrmues_egg.animation.json");
    }
}
