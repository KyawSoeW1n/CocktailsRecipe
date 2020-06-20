package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.repository.DrinkDataStore;

import javax.inject.Inject;

public class DrinkDataStoreFactory {

    private DrinkRemoteDataStore drinkRemoteDataStore;
    private DrinkCacheDataStore drinkCacheDataStore;

    @Inject
    public DrinkDataStoreFactory(DrinkRemoteDataStore drinkRemoteDataStore, DrinkCacheDataStore drinkCacheDataStore) {
        this.drinkRemoteDataStore = drinkRemoteDataStore;
        this.drinkCacheDataStore = drinkCacheDataStore;
    }

    public DrinkDataStore getDrinkRemoteDataStore() {
        return drinkRemoteDataStore;
    }

    public DrinkDataStore getDrinkCacheDataStore() {
        return drinkCacheDataStore;
    }
}
