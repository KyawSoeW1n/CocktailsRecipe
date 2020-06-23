package com.kurio.cocktail.injection.module;

import android.util.Log;

import com.kurio.cocktail.BuildConfig;
import com.kurio.cocktail.data.remote.service.CocktailService;
import com.kurio.cocktail.data.remote.service.CocktailServiceFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteModule {

    @Singleton
    @Provides
    @Inject
    public CocktailService provideCocktailService(CocktailServiceFactory cocktailServiceFactory) {
        return cocktailServiceFactory.makeCocktailService(BuildConfig.DEBUG);
    }

    @Provides
    public CocktailServiceFactory provideServiceFactory() {
        //  TODO:Add base URL for production
        String baseUrl = "https://www.thecocktaildb.com";
        Log.i("CreateFactory", baseUrl);
        return new CocktailServiceFactory(baseUrl);
    }
}
