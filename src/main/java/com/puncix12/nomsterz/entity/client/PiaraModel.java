package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.PellattEntity;
import com.puncix12.nomsterz.entity.custom.PiaraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PiaraModel extends AnimatedGeoModel<PiaraEntity> {
    @Override
    public ResourceLocation getModelResource(PiaraEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/piara.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PiaraEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/piara.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PiaraEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/piara.animation.json");
    }
}
