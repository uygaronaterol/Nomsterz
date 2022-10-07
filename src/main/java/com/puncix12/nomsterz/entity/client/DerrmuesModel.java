package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.AhagrioqEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DerrmuesModel extends AnimatedGeoModel<DerrmuesEntity> {
    @Override
    public ResourceLocation getModelResource(DerrmuesEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/derrmues.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DerrmuesEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/derrmues.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DerrmuesEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/derrmues.animation.json");
    }
}
