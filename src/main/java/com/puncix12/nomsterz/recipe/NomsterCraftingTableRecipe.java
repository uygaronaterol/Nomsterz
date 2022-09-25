package com.puncix12.nomsterz.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.puncix12.nomsterz.Nomsterz;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class NomsterCraftingTableRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public NomsterCraftingTableRecipe(ResourceLocation id, ItemStack output,
                                    NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }
        else if(recipeItems.get(0).test(pContainer.getItem(0)) &&
                recipeItems.get(1).test(pContainer.getItem(1)) &&
                recipeItems.get(2).test(pContainer.getItem(2)) &&
                recipeItems.get(3).test(pContainer.getItem(3)) &&
                recipeItems.get(4).test(pContainer.getItem(4)) &&
                recipeItems.get(5).test(pContainer.getItem(5)) &&
                recipeItems.get(6).test(pContainer.getItem(6)) &&
                recipeItems.get(7).test(pContainer.getItem(7)) &&
                recipeItems.get(8).test(pContainer.getItem(8)) ){
            return true;
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }
    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<NomsterCraftingTableRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "nomster_crafting";
    }

    public static class Serializer implements RecipeSerializer<NomsterCraftingTableRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Nomsterz.MOD_ID, "nomster_crafting");

        //PUT ACACIA SLAB IN RECIPE INSTEAD OF EMPTY AND TRY TO FIX IT LATER
        @Override
        public NomsterCraftingTableRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(9, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                if(!Ingredient.fromJson(ingredients.get(i)).test(Items.ACACIA_SLAB.getDefaultInstance()))
                    inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
                else
                    inputs.set(i, Ingredient.EMPTY);
            }

            return new NomsterCraftingTableRecipe(pRecipeId, output, inputs);
        }

        @Override
        public @Nullable NomsterCraftingTableRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new NomsterCraftingTableRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, NomsterCraftingTableRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}
