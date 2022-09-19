package com.puncix12.nomsterz.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab NOMSTERZ_TAB = new CreativeModeTab("nomster_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DAWG_SKIN.get());
        }
    };
}
