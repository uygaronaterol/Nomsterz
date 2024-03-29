package com.puncix12.nomsterz.entity.custom;
import com.mojang.math.Vector3d;
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
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
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
import software.bernie.shadowed.eliotlash.mclib.utils.MathHelper;

public class DNightEntity extends TamableAnimal implements IAnimatable, PlayerRideableJumping {
    private AnimationFactory factory = new AnimationFactory(this);
    public DNightEntity(EntityType<? extends TamableAnimal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.maxUpStep = 1.0F;
    }
    private static int shouldBreakBlocks = 0;
    private static int shouldGoDown = 0;
    private static int shouldShoot = 0;

    protected float playerJumpPendingScale;
    private boolean allowStandSliding;
    protected boolean isJumping;
    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 450.0D)
                .add(Attributes.ATTACK_DAMAGE, 12f)
                .add(Attributes.ATTACK_SPEED, 1f)
                .add(Attributes.MOVEMENT_SPEED, 0.8f)
                .add(Attributes.JUMP_STRENGTH, 3.5f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100f)
                .add(Attributes.ATTACK_KNOCKBACK, 10f)
                .add(Attributes.ARMOR, 6f)
                .add(Attributes.FOLLOW_RANGE, 2000f).build();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if(pSource == DamageSource.GENERIC )
            return false;
        else if(pSource == DamageSource.FALL ) {
            destroyBlocksInAABB(this.getBoundingBox());
            return false;
        }
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
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Cow.class, false));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Horse.class, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Sheep.class, false));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Pig.class, false));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, Chicken.class, false));



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
                    pEntity.setSecondsOnFire(i);
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
        return 105 + this.level.random.nextInt(5);
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity p_20123_) {
        return super.getDismountLocationForPassenger(p_20123_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob mob) {
        return ModEntityTypes.DNIGHT.get().create(serverLevel);
    }


    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.getItem().equals(ModItems.RAW_WAPAULENDO_MEAT.get());
    }

    public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
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

            } else if ( itemstack.is(ModItems.RAW_PELLATT_MEAT.get()) && this.isBaby()  ) {
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
        if (event.isMoving() && this.isOnGround()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dnight.walk", true));
            return PlayState.CONTINUE;
        }
        else if(!this.isOnGround() && !this.isInWater()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dnight.fly", true));
            return PlayState.CONTINUE;
        }
        else if(this.isInSittingPose() ){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dnight.sit", true));
            return PlayState.CONTINUE;
        }
        else if(!this.isInSittingPose()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dnight.idle", true));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void tick() {
        LivingEntity livingentity = this.getTarget();
        shouldGoDown++;
        shouldShoot++;
        if (livingentity != null && !this.isVehicle() && this.isInWater() && shouldGoDown >= 3000) {
            this.setNoGravity(false);
            if(shouldGoDown > 6000){
                shouldGoDown = 0;
            }
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
        if (livingentity != null && !this.isVehicle() && shouldGoDown >= 3000) {
            this.setNoGravity(false);
            if(shouldGoDown > 6000) {
                shouldGoDown = 0;
            }

        }
        if (livingentity != null && shouldGoDown < 3000 && !this.isVehicle()) {
            this.setNoGravity(true);
            this.destroyBlocksInAABB(this.getBoundingBox());
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
                Vec3 vec4 = new Vec3(this.getX() - livingentity.getX(), this.getY() - livingentity.getY() -25, this.getZ() - livingentity.getZ());

                if( this.getY() >= livingentity.getY() + 25f ) {
                    this.setDeltaMovement(-(float) vec3.x / 20.0F, (-(float) vec4.y / 20.0F)  , -(float) vec3.z / 20.0F);
                }
                else {
                    this.setDeltaMovement(-(float) vec3.x / 20.0F, (-(float) vec3.y / 20.0F) + 1f , -(float) vec3.z / 20.0F);

                }
            }

        }
        else if(livingentity == null && !this.isVehicle()){
            this.setNoGravity(false);
            //shouldGoDown = 0;

        }
        if( shouldBreakBlocks > 30 && this.getTarget() != null){
            this.destroyBlocksInAABB(this.getBoundingBox());
            shouldBreakBlocks = 0;
        }
        if(livingentity != null && !this.isVehicle() && shouldShoot > 60){
            shouldShoot = 0;
            this.attackEntityWithRangedAttack(this.getTarget());
        }
        shouldBreakBlocks++;
        super.tick();
    }


    private boolean destroyBlocksInAABB(AABB area) {
        int i = (int) Math.floor(area.minX - 4);
        int j = (int) Math.floor(area.minY );
        int k = (int) Math.floor(area.minZ - 4);
        int l = (int) Math.floor(area.maxX + 4);
        int i1 = (int) Math.floor(area.maxY + 4);
        int j1 = (int) Math.floor(area.maxZ + 4);
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
                    addAnimation("animation.dnight.attack", false));
            this.swinging = false;
            playSound(ModSounds.DNIGHT_ATTACK.get());
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
                this.getY(1D) + p_19957_.getMyRidingOffset() + 4.2D,
                this.getZ() + (double)(4F * f1));
        if (p_19957_ instanceof LivingEntity) {
            ((LivingEntity)p_19957_).yBodyRot = this.yBodyRot;

        }
    }


    @Override
    public void travel(Vec3 p_30633_) {
        if (this.isAlive()) {
            LivingEntity livingentity =  this.getControllingPassenger();
            if (this.isVehicle() && this.isTame()&& this.getControllingPassenger() != null && !this.isBaby()) {
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (this.isVehicle() && !this.isOnGround()) {
                    this.setNoGravity(true);
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED)*300);
                    super.travel(new Vec3((double)f, -this.getPassengers().get(0).xRotO % 1, (double)f1));
                }else if (this.isVehicle() && this.isOnGround()) {
                    this.setNoGravity(false);
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3((double)f, -this.getPassengers().get(0).xRotO % 1, (double)f1));
                }
                else if (livingentity instanceof Player) {
                    this.setNoGravity(false);
                    this.setDeltaMovement(Vec3.ZERO);
                }

                this.calculateEntityAnimation(this, false);
            }
            else{
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

        if(this.getTarget() != null && !this.isBaby() && !this.isTame()) {
            this.destroyBlocksInAABB(this.getBoundingBox());
            this.attackEntityWithRangedAttack(this.getTarget());

        }
        return ModSounds.DNIGHT_IDLE.get();

    }


    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.DNIGHT_HIT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DNIGHT_DEATH.get();
    }

    public void attackEntityWithRangedAttack(LivingEntity target) {

        if(this.getTarget() instanceof  LivingEntity)  {
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.33D) - this.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);

            DNightProjectile arrow = new DNightProjectile(ModEntityTypes.DNIGHT_PROJECTILE.get(), this, this.level);
            if(d3 > 10){
                arrow.setDeltaMovement(d0, d1 + 0.2f , d2);
            }
            else
                arrow.setDeltaMovement(d0 + Math.random()/5, d1 + Math.random()/5 , d2+ Math.random()/5);
            this.level.addFreshEntity(arrow);

        }
    }
}
