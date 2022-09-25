package com.puncix12.nomsterz.integration;

import com.puncix12.nomsterz.Nomsterz;
import com.puncix12.nomsterz.block.ModBlocks;
import com.puncix12.nomsterz.recipe.NomsterCraftingTableRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class NomsterCraftingTableRecipeCategory implements IRecipeCategory<NomsterCraftingTableRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Nomsterz.MOD_ID, "nomster_crafting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Nomsterz.MOD_ID, "textures/gui/nomster_crafting_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public NomsterCraftingTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.NOMSTER_CRAFTING_TABLE.get()));
    }

    @Override
    public RecipeType<NomsterCraftingTableRecipe> getRecipeType() {
        return JEINomsterzPlugin.NOMSTER_CRAFTING;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Nomster Crafting Table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, NomsterCraftingTableRecipe recipe, IFocusGroup focuses) {

        int z = 0;
        for( int x = 30; x < 70; x+=18 ) {
            for( int y = 19; y < 60; y+=18 ) {
                builder.addSlot(RecipeIngredientRole.INPUT, x, y).addIngredients(recipe.getIngredients().get(z));
                z++;
            }

        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 37).addItemStack(recipe.getResultItem());
    }
}
