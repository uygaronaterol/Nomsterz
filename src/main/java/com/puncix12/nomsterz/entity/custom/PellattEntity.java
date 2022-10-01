package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
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

public class PellattEntity extends TamableAnimal implements IAnimatable, PlayerRideableJumping {
    private AnimationFactory factory = new AnimationFactory(this);
    public PellattEntity(EntityType<? extends TamableAnimal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.maxUpStep = 1.0F;
    }
    protected float playerJumpPendingScale;
    private boolean allowStandSliding;
    protected boolean isJumping;

    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 6f)
                .add(Attributes.ATTACK_SPEED, 1f)
                .add(Attributes.MOVEMENT_SPEED, 0.6f)
                .add(Attributes.JUMP_STRENGTH, 0.8f)
                .add(Attributes.FOLLOW_RANGE, 20000f).build();
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
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, NyangaEntity.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Chicken.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Sheep.class, true));


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
        return ModEntityTypes.PELLATT.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.getItem().equals(Items.APPLE);
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
                else if ( itemstack.is(Items.COD) || itemstack.is(Items.TROPICAL_FISH) || itemstack.is(Items.SALMON)) {
                    InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
                        itemstack.shrink(1);
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }
                else if(itemstack.isEmpty() && !this.isInSittingPose()) {
                    this.doPlayerRide(p_30412_);
                    if(this.isInWater()){
                        this.setOrderedToSit(false);
                    }
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }

            } else if ( (itemstack.is(ModBlocks.LAUS_SAPLING.get().asItem()) || itemstack.is(ModItems.MEAT_PACKAGE.get()))&& this.getHealth() < 10) {
                if (!p_30412_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(7) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pellatt.walk", true));
            return PlayState.CONTINUE;
        }
        else if(this.isInSittingPose() ){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pellatt.sit", true));
            return PlayState.CONTINUE;
        }
        else if(!this.isInSittingPose()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pellatt.idle", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public float getSpeed() {
        if(this.isInWater()){
            return 1.2f;
        }
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
                    addAnimation("animation.pellatt.attack", false));
            this.swinging = false;
            playSound(ModSounds.PELLATT_ATTACK.get());
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
        p_19957_.setPos(this.getX() - (double)(1F * f),
                this.getY(0.5D) + p_19957_.getMyRidingOffset() + 1.2D,
                this.getZ() + (double)(1F * f1));
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
            } else {
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
        return ModSounds.PELLATT_IDLE.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.PELLATT_HIT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.PELLATT_DEATH.get();
    }
}
