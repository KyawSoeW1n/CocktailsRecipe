package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.repository.DrinkCache;
import com.kurio.cocktail.data.repository.DrinkDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;


public class DrinkCacheDataStore implements DrinkDataStore {

    private DrinkCache drinkCache;

    @Inject
    public DrinkCacheDataStore(DrinkCache drinkCache) {
        this.drinkCache = drinkCache;
    }

    @Override
    public Single<List<CocktailEntity>> fetchDrink(String route) {
        throw new UnsupportedOperationException("Fetch Drink is not available in Cache");
    }

    @Override
    public Single<List<CocktailDetailEntity>> fetchDrinkDetail(String id) {
        throw new UnsupportedOperationException("Fetch Drink Detail is not available in Cache");
    }

    @Override
    public Single<List<CacheDrinkEntity>> getCacheDrinkList() {
        return drinkCache.getCacheDrinkList();
    }

    @Override
    public Completable removeDrink(String drinkId) {
        return drinkCache.removeDrink(drinkId);
    }

    @Override
    public Completable removeAllDrink() {
        return drinkCache.removeAllDrink();
    }

    @Override
    public Completable saveDrink(CacheDrinkEntity cacheDrinkEntity) {
        return drinkCache.saveDrink(cacheDrinkEntity);
    }
}