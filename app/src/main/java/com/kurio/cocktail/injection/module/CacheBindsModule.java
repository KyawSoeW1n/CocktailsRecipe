package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.cache.CacheDrinkImpl;
import com.kurio.cocktail.cache.CacheIngredientImpl;
import com.kurio.cocktail.data.repository.DrinkCache;
import com.kurio.cocktail.data.repository.IngredientCache;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CacheBindsModule {
    @Binds
    public abstract DrinkCache bindDrinkCache(CacheDrinkImpl cacheDrink);

    @Binds
    public abstract IngredientCache bindIngredientCache(CacheIngredientImpl cacheIngredient);
}
