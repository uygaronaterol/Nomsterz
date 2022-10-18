package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class BekorProjectile extends AbstractArrow {
    public BekorProjectile(EntityType<BekorProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public BekorProjectile(EntityType<BekorProjectile> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public BekorProjectile(EntityType<BekorProjectile> entityType, LivingEntity shooter, Level world) {
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
                ((LivingEntity)pResult.getEntity()).addEffect(new MobEffectInstance(MobEffects.POISON, i * 20, 0),pResult.getEntity());

            }
        }
    }

    @Override
    public void setBaseDamage(double pBaseDamage) {
        super.setBaseDamage(6);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Entity entity = this;
        GhogaEntity ghoga = ModEntityTypes.GHOGA.get().create(level);
        ghoga.setBaby(true);
        ghoga.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
        level.addFreshEntity(ghoga);
        super.onHitBlock(pResult);
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