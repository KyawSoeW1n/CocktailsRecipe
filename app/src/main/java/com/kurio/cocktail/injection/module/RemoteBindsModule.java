package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.data.remote.DrinkImpl;
import com.kurio.cocktail.data.remote.IngredientImpl;
import com.kurio.cocktail.data.repository.DrinkRemote;
import com.kurio.cocktail.data.repository.IngredientRemote;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RemoteBindsModule {
    @Binds
    public abstract DrinkRemote bindDrinkRemote(DrinkImpl drink);

    @Binds
    public abstract IngredientRemote bindIngredientRemote(IngredientImpl ingredient);
}
