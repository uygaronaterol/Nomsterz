package com.puncix12.nomsterz.item.custom;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class TridentFromDepthsItem extends SwordItem {

    public TridentFromDepthsItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity) {
            int i = 0;
            if(((LivingEntity) pEntity).getHealth() > 0.5f){
                i++;
            }
            if (i > 0 && pEntity.isInWater()) {
                ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, i * 20, 0,true,false), pEntity);
                ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, i * 20, 0,true,false), pEntity);
                ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, i * 20, 0,true,false), pEntity);

            }
        }
    }


}
