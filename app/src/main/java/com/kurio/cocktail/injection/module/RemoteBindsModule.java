package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.data.remote.CocktailImpl;
import com.kurio.cocktail.data.repository.CocktailRemote;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RemoteBindsModule {
    @Binds
    public abstract CocktailRemote bindSessionRemote(CocktailImpl sessionRemote);
}
