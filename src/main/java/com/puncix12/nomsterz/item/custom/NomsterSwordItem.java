package com.puncix12.nomsterz.item.custom;

import com.puncix12.nomsterz.enchantment.ModEnchantments;
import com.puncix12.nomsterz.enchantment.NomsterSwordSharpnessEnchantment;
import com.puncix12.nomsterz.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class NomsterSwordItem extends SwordItem {

    private int enchantmentLevel = 0;
    public NomsterSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 25.0F;
        } else {
            Material material = pState.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !pState.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : 1.5F;
        }
    }



    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        Player pPlayer = pContext.getPlayer();
        assert pPlayer != null;
        if(pPlayer.getInventory().contains(ModItems.NOMSTER_ESSENCE.get().getDefaultInstance())){
            int i = pPlayer.getInventory().findSlotMatchingItem(ModItems.NOMSTER_ESSENCE.get().getDefaultInstance());
            ItemStack stack = pPlayer.getInventory().getItem(i);
            if(stack.getCount() >= 50){
                stack.shrink(50);
                enchantmentLevel = pContext.getItemInHand().getEnchantmentLevel(ModEnchantments.NOMSTER_SWORD_SHARPNESS.get());
                EquipmentSlot slot = pContext.getPlayer().getItemInHand(pContext.getHand()).getEquipmentSlot();
                if(enchantmentLevel > 0){
                    pContext.getItemInHand().shrink(1);
                }
                if(enchantmentLevel > 0 && !pContext.getItemInHand().is(ModItems.NOMSTER_SWORD.get())){
                    ItemStack nS = ModItems.NOMSTER_SWORD.get().getDefaultInstance();
                    nS.enchant(ModEnchantments.NOMSTER_SWORD_SHARPNESS.get(), enchantmentLevel + 1);
                    pContext.getPlayer().getInventory().add( nS );
                }
                else if(enchantmentLevel <= 0)
                    pContext.getItemInHand().enchant(ModEnchantments.NOMSTER_SWORD_SHARPNESS.get(), 1);
            }
        }
        return super.useOn(pContext);
    }
}
