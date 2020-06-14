package com.kurio.cocktail.data.store;

import javax.inject.Inject;

public class IngredientDataStoreFactory {

    private IngredientRemoteDataStore ingredientRemoteDataStore;

    @Inject
    public IngredientDataStoreFactory(IngredientRemoteDataStore ingredientRemoteDataStore) {
        this.ingredientRemoteDataStore = ingredientRemoteDataStore;
    }

    public IngredientRemoteDataStore getRemoteDataStore() {
        return ingredientRemoteDataStore;
    }
}
