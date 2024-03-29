package com.puncix12.nomsterz.entity.custom;

import com.puncix12.nomsterz.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DNightEggEntity extends Animal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public DNightEggEntity(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double p_27598_) {
        return false;
    }

    private int shouldHatch = 0;
    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.ATTACK_DAMAGE, 0f)
                .add(Attributes.ATTACK_SPEED, 0f)
                .add(Attributes.MOVEMENT_SPEED, 0f)
                .add(Attributes.FOLLOW_RANGE, 20000f).build();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dnight_egg.idle", true));
        return PlayState.CONTINUE;
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }
    @Override
    public void tick() {
        Level level = this.getLevel();
        BlockPos pPos = this.getOnPos();
        Entity entity = this;
        BlockState blockstate = level.getBlockState(pPos);
        BlockState blockstate1 = level.getBlockState(pPos.above().east());
        BlockState blockstate2 = level.getBlockState(pPos.above().west());
        BlockState blockstate3 = level.getBlockState(pPos.above().north());
        BlockState blockstate4 = level.getBlockState(pPos.above().south());

        if ( blockstate.is(Blocks.BLUE_TERRACOTTA) && shouldHatch == 10000 && blockstate1.is(Blocks.SMOOTH_SANDSTONE)
                &&  blockstate2.is(Blocks.SMOOTH_SANDSTONE) && blockstate3.is(Blocks.SMOOTH_SANDSTONE)
                && blockstate4.is(Blocks.SMOOTH_SANDSTONE)){
            level.removeBlock(pPos, false);
            level.removeBlock(pPos.above(), false);
            level.removeBlock(pPos.above().east(), false);
            level.removeBlock(pPos.above().west(), false);
            level.removeBlock(pPos.above().north(), false);
            level.removeBlock(pPos.above().south(), false);
            this.die(DamageSource.ANVIL);
            this.remove(RemovalReason.KILLED);
            DNightEntity dnight = ModEntityTypes.DNIGHT.get().create(level);
            dnight.setBaby(true);
            dnight.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
            level.addFreshEntity(dnight);
            playSound(SoundEvents.TURTLE_EGG_BREAK);
        }
        if(blockstate.is(Blocks.BLUE_TERRACOTTA) && blockstate1.is(Blocks.SMOOTH_SANDSTONE)
                &&  blockstate2.is(Blocks.SMOOTH_SANDSTONE) && blockstate3.is(Blocks.SMOOTH_SANDSTONE)
                && blockstate4.is(Blocks.SMOOTH_SANDSTONE)) {
            shouldHatch++;
        }
        if(shouldHatch > 10000)
            shouldHatch = 0;
        super.tick();
    }
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public boolean canBeLeashed(Player pPlayer) {
        return false;
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.TURTLE_EGG_CRACK;
    }
}
