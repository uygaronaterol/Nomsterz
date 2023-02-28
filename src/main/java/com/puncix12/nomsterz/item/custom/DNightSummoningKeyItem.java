package com.puncix12.nomsterz.item.custom;

import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.entity.custom.DNightEggEntity;
import com.puncix12.nomsterz.entity.custom.DNightEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DNightSummoningKeyItem extends Item {
    public DNightSummoningKeyItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pPos = pContext.getClickedPos();
        Entity entity = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(pPos);
        BlockState blockState1 = level.getBlockState(pPos.below());
        if ( blockstate.is(ModBlocks.SUMMONING_ALTAR.get()) && blockState1.is(Blocks.BLUE_GLAZED_TERRACOTTA)) {
            level.removeBlock(pPos, false);
            DNightEntity dnight = ModEntityTypes.DNIGHT.get().create(level);
            dnight.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
            level.addFreshEntity(dnight);
        }
        return super.useOn(pContext);
    }

}
