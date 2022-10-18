package com.puncix12.nomsterz.enchantment;

import com.puncix12.nomsterz.Nomsterz;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Nomsterz.MOD_ID);

    public static RegistryObject<Enchantment> NOMSTER_SWORD_SHARPNESS =
            ENCHANTMENTS.register("nomster_sword_sharpness",
                    () -> new NomsterSwordSharpnessEnchantment(Enchantment.Rarity.VERY_RARE,
                            0, EquipmentSlot.MAINHAND));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
