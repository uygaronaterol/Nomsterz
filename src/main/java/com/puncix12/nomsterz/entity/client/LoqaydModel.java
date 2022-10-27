package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.KashisosEntity;
import com.puncix12.nomsterz.entity.custom.LoqaydEntity;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LoqaydModel extends AnimatedGeoModel<LoqaydEntity> {
    @Override
    public ResourceLocation getModelResource(LoqaydEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/loqayd.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LoqaydEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/loqayd.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LoqaydEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/loqayd.animation.json");
    }
}
