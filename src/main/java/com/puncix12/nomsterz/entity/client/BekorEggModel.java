package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.BekorEggEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEggEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BekorEggModel extends AnimatedGeoModel<BekorEggEntity> {
    @Override
    public ResourceLocation getModelResource(BekorEggEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/bekor_egg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BekorEggEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/bekor_egg.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BekorEggEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/bekor_egg.animation.json");
    }
}
