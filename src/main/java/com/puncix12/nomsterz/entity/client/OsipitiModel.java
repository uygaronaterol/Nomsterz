package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.OsipitiEntity;
import com.puncix12.nomsterz.entity.custom.PellattEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OsipitiModel extends AnimatedGeoModel<OsipitiEntity> {
    @Override
    public ResourceLocation getModelResource(OsipitiEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/osipiti.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OsipitiEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/osipiti.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OsipitiEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/osipiti.animation.json");
    }
}
