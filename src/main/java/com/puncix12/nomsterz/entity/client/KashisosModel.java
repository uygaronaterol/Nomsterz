package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.KashisosEntity;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KashisosModel extends AnimatedGeoModel<KashisosEntity> {
    @Override
    public ResourceLocation getModelResource(KashisosEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/kashisos.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KashisosEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/kashisos.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KashisosEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/kashisos.animation.json");
    }
}
