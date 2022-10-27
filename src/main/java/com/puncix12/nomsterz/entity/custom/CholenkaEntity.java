package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.item.ModItems;
import com.puncix12.nomsterz.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.shadowed.eliotlash.mclib.utils.MathHelper;

public class CholenkaEntity extends TamableAnimal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public CholenkaEntity(EntityType<? extends TamableAnimal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.maxUpStep = 1.0F;

    }
    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    @Override
    public boolean canSwimInFluidType(FluidType type) {
        return true;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return super.getSwimSound();
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
        return 8 + this.level.random.nextInt(5);
    }

    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 6f)
                .add(Attributes.ATTACK_SPEED, 1.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.6f)
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
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, NyangaEntity.class, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Cow.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Sheep.class, true));


    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        return ModEntityTypes.CHOLENKA.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.getItem().equals(Items.PHANTOM_MEMBRANE) ;
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
                else if ( itemstack.is(Items.STICK)) {
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

            } else if (itemstack.is(ModItems.MEAT_PACKAGE.get())) {
                if (!p_30412_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
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


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cholenka.walk", true));
            return PlayState.CONTINUE;
        }
        else if(this.isInSittingPose() ){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cholenka.sit", true));
            return PlayState.CONTINUE;
        }
        else if(!this.isInSittingPose()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cholenka.idle", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void tick() {
        super.tick();
    }
    public boolean hasTarget(){
        if(this.getTarget() == null)
            return false;
        return true;
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
                    addAnimation("animation.cholenka.attack", false));
            this.swinging = false;
            playSound(SoundEvents.BEE_STING);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean canBeLeashed(Player p_21813_) {
        return false;
    }

    @Override
    protected boolean canRide(Entity p_20339_) {
        return false;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        attackEntityWithRangedAttack((LivingEntity)this.getTarget());
        return SoundEvents.BEE_LOOP;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.BEE_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BEE_DEATH;
    }

    public void attackEntityWithRangedAttack(LivingEntity target) {

        if(this.getTarget() instanceof  LivingEntity) {
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.11D) - this.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);

            CholenkaProjectile arrow = new CholenkaProjectile(ModEntityTypes.CHOLENKA_PROJECTILE.get(), this, this.level);
            if(d3 > 10){
                arrow.setDeltaMovement(d0, d1 + 0.2f , d2);
            }
            else
                arrow.setDeltaMovement(d0, d1  , d2);
            this.level.addFreshEntity(arrow);

        }
    }


}
