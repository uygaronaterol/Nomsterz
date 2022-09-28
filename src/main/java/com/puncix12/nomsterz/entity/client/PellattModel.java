package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.PellattEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PellattModel extends AnimatedGeoModel<PellattEntity> {
    @Override
    public ResourceLocation getModelResource(PellattEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/pellatt.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PellattEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/pellatt.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PellattEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/pellatt.animation.json");
    }
}
