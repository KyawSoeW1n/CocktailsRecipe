package com.kurio.cocktail.data.store;

import javax.inject.Inject;

public class CocktailDataStoreFactory {

    private CocktailRemoteDataStore drinkListRemoteDataStore;

    @Inject
    public CocktailDataStoreFactory(CocktailRemoteDataStore drinkListRemoteDataStore) {
        this.drinkListRemoteDataStore = drinkListRemoteDataStore;
    }

    public CocktailRemoteDataStore getRemoteDataStore() {
        return drinkListRemoteDataStore;
    }
}
