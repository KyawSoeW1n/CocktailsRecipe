package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.data.CocktailDataRepository;
import com.kurio.cocktail.domain.repository.CocktailRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {
    @Binds
    public abstract CocktailRepository bindDrinkRepository(CocktailDataRepository currencyDataRepository);
}
