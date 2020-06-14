package com.kurio.cocktail.data.store;

import javax.inject.Inject;

public class IngredientDataStoreFactory {

    private IngredientRemoteDataStore ingredientRemoteDataStore;
    private IngredientCacheDataStore ingredientCacheDataStore;

    @Inject
    public IngredientDataStoreFactory(IngredientRemoteDataStore ingredientRemoteDataStore, IngredientCacheDataStore ingredientCacheDataStore) {
        this.ingredientRemoteDataStore = ingredientRemoteDataStore;
        this.ingredientCacheDataStore = ingredientCacheDataStore;
    }

    public IngredientRemoteDataStore getIngredientRemoteDataStore() {
        return ingredientRemoteDataStore;
    }

    public IngredientCacheDataStore getIngredientCacheDataStore() {
        return ingredientCacheDataStore;
    }
}
