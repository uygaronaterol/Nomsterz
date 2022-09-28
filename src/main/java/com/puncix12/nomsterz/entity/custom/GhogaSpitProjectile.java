package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class GhogaSpitProjectile extends AbstractArrow {
    public GhogaSpitProjectile(EntityType<GhogaSpitProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public GhogaSpitProjectile(EntityType<GhogaSpitProjectile> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public GhogaSpitProjectile(EntityType<GhogaSpitProjectile> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if(pResult.getEntity().isAlive())
            pResult.getEntity().setSecondsOnFire(3);
        pResult.getEntity().causeFallDamage(4,2, DamageSource.FALL);
    }

    @Override
    protected void tickDespawn() {
        this.discard();

    }

    @Override
    protected ItemStack getPickupItem() {
        return ModItems.GHOGA_SPIT.get().getDefaultInstance();
    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}