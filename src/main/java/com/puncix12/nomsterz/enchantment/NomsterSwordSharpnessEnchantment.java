package com.puncix12.nomsterz.enchantment;


import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;

public class NomsterSwordSharpnessEnchantment extends DamageEnchantment {


    public NomsterSwordSharpnessEnchantment(Rarity pRarity, int pType, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pType, pApplicableSlots);
    }

    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem().getDefaultInstance().is(ModItems.NOMSTER_SWORD.get());
    }

    @Override
    public int getMaxLevel() {
        return 200;
    }
}