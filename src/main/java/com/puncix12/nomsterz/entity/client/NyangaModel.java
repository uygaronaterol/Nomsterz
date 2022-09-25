package com.puncix12.nomsterz.entity.client;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.entity.custom.NatshaiEntity;
import com.puncix12.nomsterz.entity.custom.NyangaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NyangaModel extends AnimatedGeoModel<NyangaEntity> {
    @Override
    public ResourceLocation getModelResource(NyangaEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "geo/nyanga.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NyangaEntity object) {
        return new ResourceLocation(Nomsterz.MOD_ID, "textures/entity/nyanga.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NyangaEntity animatable) {
        return new ResourceLocation(Nomsterz.MOD_ID, "animations/nyanga.animation.json");
    }
}
