package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DerrmuesEntity extends TamableAnimal implements IAnimatable, PlayerRideableJumping {
    private AnimationFactory factory = new AnimationFactory(this);
    public DerrmuesEntity(EntityType<? extends TamableAnimal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.maxUpStep = 1.0F;
    }
    private int shouldBreakBlocks = 0;
    protected float playerJumpPendingScale;
    private boolean allowStandSliding;
    protected boolean isJumping;
    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 250.0D)
                .add(Attributes.ATTACK_DAMAGE, 16f)
                .add(Attributes.ATTACK_SPEED, 1f)
                .add(Attributes.MOVEMENT_SPEED, 0.7f)
                .add(Attributes.JUMP_STRENGTH, 1.8f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100f)
                .add(Attributes.FOLLOW_RANGE, 20000f).build();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        Entity entity = pSource.getDirectEntity();
        if (entity instanceof AbstractArrow) {
            return false;
        }
        else if(pSource == DamageSource.GENERIC )
            return false;
        else if(pSource == DamageSource.FALL )
            return false;
        destroyBlocksInAABB(this.getBoundingBox());
        return super.hurt(pSource, pAmount);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal( 1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal( 2, new BreedGoal(this, 1.0D));

        this.goalSelector.addGoal( 4, new FollowOwnerGoal(this, 0.7,2,100,false));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.6D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));



    }
    public boolean doHurtTarget(Entity pEntity) {
        if (super.doHurtTarget(pEntity)) {
            if (pEntity instanceof LivingEntity) {
                int i = 0;
                if (this.level.getDifficulty() == Difficulty.NORMAL) {
                    i = 7;
                } else if (this.level.getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }

                if (i > 0) {
                    ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i * 20, 3), this);
                }
            }

            return true;
        } else {
            return false;
        }
    }


    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double p_27598_) {
        return false;
    }

    public int getExperienceReward() {
        return 5 + this.level.random.nextInt(5);
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity p_20123_) {
        return super.getDismountLocationForPassenger(p_20123_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        return ModEntityTypes.DERRMUES.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.getItem().equals(ModItems.RAW_SWERDARM_MEAT.get());
    }

    public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();
        if(isFood(itemstack)){
            return super.mobInteract(p_30412_,p_30413_);
        }
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(p_30412_) || this.isTame() || itemstack.is(Items.BONE) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.heal((float)itemstack.getFoodProperties(this).getNutrition());
                    this.gameEvent(GameEvent.EAT, this);
                    return InteractionResult.SUCCESS;
                }

                if ( itemstack.is(ModItems.NOMSTER_COMMANDER.get())) {
                    InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }
                else if(itemstack.isEmpty() && !this.isInSittingPose() && !this.isBaby()) {
                    this.doPlayerRide(p_30412_);
                    if(this.isInWater()){
                        this.setOrderedToSit(false);
                    }
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }

            } else if ( itemstack.is(ModItems.MEAT_PACKAGE.get())  && this.isBaby()) {
                if (!p_30412_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(63) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
                    this.tame(p_30412_);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }

                return InteractionResult.SUCCESS;
            }


            return super.mobInteract(p_30412_, p_30413_);
        }
    }
    protected void doPlayerRide(Player p_30634_) {
        if (!this.level.isClientSide) {
            p_30634_.setYRot(this.getYRot());
            p_30634_.setXRot(this.getXRot());
            p_30634_.startRiding(this);
        }

    }



    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.derrmues.walk", true));
            return PlayState.CONTINUE;
        }
        else if(this.isInSittingPose() ){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.derrmues.sit", true));
            return PlayState.CONTINUE;
        }
        else if(!this.isInSittingPose()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.derrmues.idle", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void tick() {
        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && this.isInWater()) {
            Vec3 vec3 = new Vec3(this.getX() - livingentity.getX(), this.getY() - livingentity.getY(), this.getZ() - livingentity.getZ());
            BlockState blockstate = this.level.getBlockState(new BlockPos(this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z));
            FluidState fluidstate = this.level.getFluidState(new BlockPos(this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z));
            if (fluidstate.is(FluidTags.WATER) || blockstate.isAir()) {
                double d0 = vec3.length();
                if (d0 > 0.0D) {
                    vec3.normalize();
                    double d1 = 3.0D;
                    if (d0 > 5.0D) {
                        d1 -= (d0 - 5.0D) / 5.0D;
                    }

                    if (d1 > 0.0D) {
                        vec3 = vec3.scale(d1);
                    }
                }

                if (blockstate.isAir()) {
                    vec3 = vec3.subtract(0.0D, vec3.y, 0.0D);
                }

                this.setDeltaMovement(-(float)vec3.x / 20.0F, -(float)vec3.y / 20.0F, -(float)vec3.z / 20.0F);
            }

        }
        if( shouldBreakBlocks > 30 && this.getTarget() != null){
            this.destroyBlocksInAABB(this.getBoundingBox());
            shouldBreakBlocks = 0;
        }
        shouldBreakBlocks++;
        super.tick();
    }


    private boolean destroyBlocksInAABB(AABB area) {
       int i = (int) Math.floor(area.minX - 3);
       int j = (int) Math.floor(area.minY );
       int k = (int) Math.floor(area.minZ - 3);
       int l = (int) Math.floor(area.maxX + 3);
       int i1 = (int) Math.floor(area.maxY + 4);
       int j1 = (int) Math.floor(area.maxZ + 3);
       boolean flag = false;
       boolean flag1 = false;

       for (int k1 = i; k1 <= l; ++k1) {
           for (int l1 = j; l1 <= i1; ++l1) {
               for (int i2 = k; i2 <= j1; ++i2) {
                   BlockPos blockpos = new BlockPos(k1, l1, i2);
                   BlockState blockstate = this.level.getBlockState(blockpos);
                   Block block = blockstate.getBlock();
                   if (!blockstate.isAir() && blockstate.getMaterial() != Material.FIRE) {
                       if (net.minecraftforge.common.ForgeHooks.canEntityDestroy(this.level, blockpos, this)) {
                           flag1 = this.level.removeBlock(blockpos, false) || flag1;
                       } else {
                           flag = true;
                       }
                   }
               }
           }
       }
       return true;
    }

    @Override
    public float getSpeed() {

        return super.getSpeed();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    private PlayState attackPredicate(AnimationEvent event) {
        if(this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().
                    addAnimation("animation.derrmues.attack", false));
            this.swinging = false;
            playSound(ModSounds.KASHISOS_HIT.get());
        }
        return PlayState.CONTINUE;
    }

    @javax.annotation.Nullable
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof LivingEntity) {
            return (LivingEntity)entity;
        }
        return null;
    }


    @Override
    public void positionRider(Entity p_20312_) {
        this.positionRider(p_20312_, Entity::setPos);
    }

    private void positionRider(Entity p_19957_, Entity.MoveFunction p_19958_) {
        super.positionRider(p_19957_);
        float f = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F));
        float f1 = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F));
        p_19957_.setPos(this.getX() - (double)(4F * f),
                this.getY(1D) + p_19957_.getMyRidingOffset() + 2.2D,
                this.getZ() + (double)(4F * f1));
        if (p_19957_ instanceof LivingEntity) {
            ((LivingEntity)p_19957_).yBodyRot = this.yBodyRot;

        }
    }


    @Override
    public void travel(Vec3 p_30633_) {
        if (this.isAlive()) {
            LivingEntity livingentity =  this.getControllingPassenger();
            if (this.isVehicle()) {
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }

                if (this.onGround && this.playerJumpPendingScale == 0.0F && !this.allowStandSliding) {
                    f = 0.0F;
                    f1 = 0.0F;
                }

                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
                    double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
                    double d1 = d0 + this.getJumpBoostPower();
                    Vec3 vec3 = this.getDeltaMovement();
                    this.setDeltaMovement(vec3.x, d1, vec3.z);
                    this.setIsJumping(true);
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
                    if (f1 > 0.0F) {
                        float f2 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
                    }

                    this.playerJumpPendingScale = 0.0F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3((double)f, p_30633_.y, (double)f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                if (this.onGround) {
                    this.playerJumpPendingScale = 0.0F;
                    this.setIsJumping(false);
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else if(this.isInWater()){
                this.move(MoverType.SELF, this.getDeltaMovement());
            }else {
                this.flyingSpeed = 0.02F;
                super.travel(p_30633_);
            }
        }
    }

    @Override
    public boolean canBeLeashed(Player p_21813_) {
        return false;
    }

    @Override
    protected boolean canRide(Entity p_20339_) {
        return true;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public void onPlayerJump(int p_30591_) {

        if (p_30591_ < 0) {
            p_30591_ = 0;
        } else {
            this.allowStandSliding = true;
        }

        if (p_30591_ >= 90) {
            this.playerJumpPendingScale = 1.0F;
        } else {
            this.playerJumpPendingScale = 0.4F + 0.4F * (float)p_30591_ / 90.0F;
        }
    }

    @Override
    public boolean canJump() {
        return true;
    }
    public boolean isJumping() {
        return this.isJumping;
    }

    @Override
    public void handleStartJump(int p_21695_) {
        this.allowStandSliding = true;
        this.playJumpSound();
    }
    public void playJumpSound(){

    }

    @Override
    public void handleStopJump() {}

    public void setIsJumping(boolean p_30656_) {
        this.isJumping = p_30656_;
    }

    public double getCustomJump() {
        return this.getAttributeValue(Attributes.JUMP_STRENGTH);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if(Math.random() < 0.6 ) {
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 3), this);
            if(this.getTarget() != null && !this.isBaby())
                this.destroyBlocksInAABB(this.getBoundingBox());
            return ModSounds.DERRMUES_IDLE1.get();
        }
        else if(this.getTarget() != null && !this.isBaby()) {
            this.destroyBlocksInAABB(this.getBoundingBox());
            destroyBlock(this.getTarget().getOnPos());
            return ModSounds.DERRMUES_IDLE2.get();
        }
        if(this.getTarget() != null && !this.isBaby())
            this.destroyBlocksInAABB(this.getBoundingBox());
        return ModSounds.DERRMUES_IDLE2.get();
    }


    private void destroyBlock(BlockPos Y){
        this.level.removeBlock(Y, false);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.DERRMUES_HIT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DERRMUES_DEATH.get();
    }
}
