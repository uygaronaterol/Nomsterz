package com.puncix12.nomsterz.item.custom;

import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.entity.ModEntityTypes;
import com.puncix12.nomsterz.entity.custom.BekorEggEntity;
import com.puncix12.nomsterz.entity.custom.DNightEggEntity;
import com.puncix12.nomsterz.entity.custom.DerrmuesEggEntity;
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

public class DNightEggItem extends Item {
    public DNightEggItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pPos = pContext.getClickedPos();
        Entity entity = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(pPos);
        if ( blockstate.is(Blocks.BLUE_TERRACOTTA)) {
            DNightEggEntity dnight = ModEntityTypes.DNIGHT_EGG.get().create(level);
            dnight.moveTo(pPos.getX(), pPos.getY() + 1, pPos.getZ(), entity.getYRot(), entity.getXRot());
            level.addFreshEntity(dnight);
            pContext.getItemInHand().shrink(1);
        }
        return super.useOn(pContext);
    }

}
