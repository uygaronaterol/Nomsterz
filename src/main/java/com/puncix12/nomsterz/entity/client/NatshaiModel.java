package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NatshaiModel extends AnimatedGeoModel<NatshaiEntity> {
    @Override
    public ResourceLocation getModelResource(NatshaiEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/natshai.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NatshaiEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/natshai.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NatshaiEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/natshai.animation.json");
    }
}
