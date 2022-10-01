package com.puncix12.nomsterz.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_NATSHAI_MEAT = (new FoodProperties.Builder()).nutrition(3).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3F).meat().build();
    public static final FoodProperties COOKED_NATSHAI_MEAT = (new FoodProperties.Builder()).nutrition(8).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 0.3F).meat().build();
    public static final FoodProperties MEAT_PACKAGE = (new FoodProperties.Builder()).nutrition(16).
            saturationMod(0.6f).meat().build();
    public static final FoodProperties RAW_NYANGA_MEAT = (new FoodProperties.Builder()).nutrition(3).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 0.3F).meat().build();
    public static final FoodProperties COOKED_NYANGA_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 0.3F).meat().build();
    public static final FoodProperties RAW_SWERDARM_MEAT = (new FoodProperties.Builder()).nutrition(4).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.POISON, 1500, 0), 1F).meat().build();
    public static final FoodProperties COOKED_SWERDARM_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.POISON, 300, 0), 1F).meat().build();
    public static final FoodProperties RAW_GHOGA_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1F).meat().build();
    public static final FoodProperties COOKED_GHOGA_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1F).meat().build();
    public static final FoodProperties RAW_YONSI_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), 1F).meat().build();
    public static final FoodProperties COOKED_YONSI_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.GLOWING, 600, 0), 1F).meat().build();
    public static final FoodProperties RAW_PELLATT_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DARKNESS, 600, 0), 1F).meat().build();
    public static final FoodProperties COOKED_PELLATT_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.LUCK, 600, 0), 1F).meat().build();
    public static final FoodProperties RAW_KASHISOS_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DARKNESS, 600, 0), 1F).meat().build();
    public static final FoodProperties COOKED_KASHISOS_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.LUCK, 600, 0), 1F).meat().build();
    public static final FoodProperties RAW_OHANUSH_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DARKNESS, 600, 0), 1F).meat().build();
    public static final FoodProperties COOKED_OHANUSH_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1F).meat().build();
    public static final FoodProperties RAW_ROHARK_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DARKNESS, 600, 0), 1F).meat().build();
    public static final FoodProperties COOKED_ROHARK_MEAT = (new FoodProperties.Builder()).nutrition(9).
            saturationMod(0.6f).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1F).meat().build();

    public static final FoodProperties DHIRTA = (new FoodProperties.Builder()).nutrition(2).
            saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.HEAL, 600, 0), 1F).build();
    public static final FoodProperties ILGROSU = (new FoodProperties.Builder()).nutrition(2).
            saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.GLOWING, 600, 0), 1F).build();
}
