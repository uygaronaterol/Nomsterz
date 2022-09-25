package com.puncix12.nomsterz.screen;

import com.puncix12.nomsterz.Nomsterz;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Nomsterz.MOD_ID);

    public static final RegistryObject<MenuType<NomsterCraftingTableMenu>> NOMSTER_CRAFTING_TABLE_MENU =
            registerMenuType(NomsterCraftingTableMenu::new, "nomster_crafting_table_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus bus) {
        MENUS.register(bus);
    }
}
