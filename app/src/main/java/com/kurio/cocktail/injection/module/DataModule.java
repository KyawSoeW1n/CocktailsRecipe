package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.data.DrinkDataRepository;
import com.kurio.cocktail.data.IngredientDataRepository;
import com.kurio.cocktail.domain.repository.DrinkRepository;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {
    @Binds
    public abstract DrinkRepository bindDrinkRepository(DrinkDataRepository drinkDataRepository);

    @Binds
    public abstract IngredientRepository bindIngredientRepository(IngredientDataRepository ingredientDataRepository);
}
