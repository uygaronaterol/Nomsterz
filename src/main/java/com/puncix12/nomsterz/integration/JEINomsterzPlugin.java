package com.puncix12.nomsterz.integration;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.recipe.NomsterCraftingTableRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEINomsterzPlugin implements IModPlugin {
    public static RecipeType<NomsterCraftingTableRecipe> NOMSTER_CRAFTING =
            new RecipeType<>(NomsterCraftingTableRecipeCategory.UID, NomsterCraftingTableRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Nomsterz.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                NomsterCraftingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<NomsterCraftingTableRecipe> recipesInfusing = rm.getAllRecipesFor(NomsterCraftingTableRecipe.Type.INSTANCE);
        registration.addRecipes(NOMSTER_CRAFTING, recipesInfusing);
    }
}
