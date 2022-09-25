package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import com.puncix12.nomsterz.entity.custom.SwerdarmEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SwerdarmModel extends AnimatedGeoModel<SwerdarmEntity> {
    @Override
    public ResourceLocation getModelResource(SwerdarmEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/swerdarm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SwerdarmEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/swerdarm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SwerdarmEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/swerdarm.animation.json");
    }
}
