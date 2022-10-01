package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.NyangaEntity;
import com.puncix12.nomsterz.entity.custom.OhanushEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OhanushModel extends AnimatedGeoModel<OhanushEntity> {
    @Override
    public ResourceLocation getModelResource(OhanushEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/ohanush.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OhanushEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/ohanush.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OhanushEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/ohanush.animation.json");
    }
}
