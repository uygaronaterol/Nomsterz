package com.puncix12.nomsterz.recipe;

import com.puncix12.nomsterz.Nomsterz;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Nomsterz.MOD_ID);

    public static final RegistryObject<RecipeSerializer<NomsterCraftingTableRecipe>> NOMSTER_CRAFTING_SERIALIZER =
            SERIALIZERS.register("nomster_crafting", () -> NomsterCraftingTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }
}
