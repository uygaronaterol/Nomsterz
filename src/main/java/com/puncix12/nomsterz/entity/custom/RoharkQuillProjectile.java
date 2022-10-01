package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class RoharkQuillProjectile extends AbstractArrow {
    public RoharkQuillProjectile(EntityType<RoharkQuillProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public RoharkQuillProjectile(EntityType<RoharkQuillProjectile> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public RoharkQuillProjectile(EntityType<RoharkQuillProjectile> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (pResult.getEntity() instanceof LivingEntity) {
            int i = 0;
            if(((LivingEntity) pResult.getEntity()).getHealth() > 0.5f){
                i+=((LivingEntity) pResult.getEntity()).getHealth();
            }
            if (i > 0) {
                ((LivingEntity)pResult.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i * 20, 0),pResult.getEntity());

            }
        }
    }

    @Override
    protected void tickDespawn() {
        this.discard();

    }

    @Override
    protected ItemStack getPickupItem() {
        return ModItems.ROHARK_QUILL.get().getDefaultInstance();
    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}