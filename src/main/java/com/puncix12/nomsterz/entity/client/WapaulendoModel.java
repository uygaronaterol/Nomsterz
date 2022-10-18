package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.SwerdarmEntity;
import com.puncix12.nomsterz.entity.custom.WapaulendoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WapaulendoModel extends AnimatedGeoModel<WapaulendoEntity> {
    @Override
    public ResourceLocation getModelResource(WapaulendoEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/wapaulendo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WapaulendoEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/wapaulendo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WapaulendoEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/wapaulendo.animation.json");
    }
}
