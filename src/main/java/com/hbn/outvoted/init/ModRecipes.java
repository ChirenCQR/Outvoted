package com.hbn.outvoted.init;

import com.hbn.outvoted.Outvoted;
import com.hbn.outvoted.util.RepairCostRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {
    public static DeferredRegister<IRecipeSerializer<?>> RECIPES = new DeferredRegister<>(ForgeRegistries.RECIPE_SERIALIZERS, Outvoted.MOD_ID);

    public static final RegistryObject<SpecialRecipeSerializer<RepairCostRecipe>> REPAIR_COST = RECIPES.register("repair_cost", () -> new SpecialRecipeSerializer<>(RepairCostRecipe::new));
}
