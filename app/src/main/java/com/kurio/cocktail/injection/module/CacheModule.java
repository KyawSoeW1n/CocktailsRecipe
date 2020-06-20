package com.kurio.cocktail.injection.module;

import android.app.Application;


import com.kurio.cocktail.cache.db.CocktailDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {

    @Singleton
    @Provides
    public CocktailDatabase providesDatabase(Application application) {
        return CocktailDatabase.getInstance(application);
    }
}
