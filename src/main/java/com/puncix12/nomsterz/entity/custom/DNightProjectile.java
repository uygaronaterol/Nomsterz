package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class DNightProjectile extends AbstractArrow {
    public DNightProjectile(EntityType<DNightProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public DNightProjectile(EntityType<DNightProjectile> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public DNightProjectile(EntityType<DNightProjectile> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity) {
            pResult.getEntity().setSecondsOnFire(5);
        }
        DamageSource damagesource;
        Entity entity1 = this.getOwner();
        LivingEntity livingentity = (LivingEntity)pResult.getEntity();
        this.doPostHurtEffects(livingentity);
        if (entity1 != null && livingentity != entity1 && livingentity instanceof Player && entity1 instanceof ServerPlayer && !this.isSilent()) {
            ((ServerPlayer)entity1).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
        }
        if (entity1 == null) {
            damagesource = DamageSource.arrow(this, this);
        } else {
            damagesource = DamageSource.arrow(this, entity1);
            if (entity1 instanceof LivingEntity) {
                ((LivingEntity)entity1).setLastHurtMob((LivingEntity)pResult.getEntity());
            }
        }
        if(pResult.getEntity() instanceof LivingEntity){
            pResult.getEntity().hurt(damagesource, 10f);
        }

    }



    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Entity entity = this;
        super.onHitBlock(pResult);
    }

    @Override
    protected void tickDespawn() {
        this.discard();

    }

    @Override
    protected ItemStack getPickupItem() {
        return Items.BLAZE_POWDER.getDefaultInstance();
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}