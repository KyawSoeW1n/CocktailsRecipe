package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.repository.DrinkDataStore;
import com.kurio.cocktail.data.repository.DrinkRemote;
import com.kurio.cocktail.domain.model.CacheDrink;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DrinkRemoteDataStore implements DrinkDataStore {

    private DrinkRemote cocktailRemote;

    @Inject
    public DrinkRemoteDataStore(DrinkRemote drinkRemote) {
        this.cocktailRemote = drinkRemote;
    }

    @Override
    public Single<List<CocktailEntity>> fetchDrink(String route) {
        return cocktailRemote.getAlcoholicDrinks(route);
    }

    @Override
    public Single<List<CocktailDetailEntity>> fetchDrinkDetail(String id) {
        return cocktailRemote.getDrinkDetail(id);
    }

    @Override
    public Single<List<CacheDrinkEntity>> getCacheDrinkList() {
        throw new UnsupportedOperationException("Cache is not available in Remote");
    }

    @Override
    public Single<CacheDrinkEntity> getCacheDrink(String id) {
        throw new UnsupportedOperationException("Cache is not available in Remote");
    }

    @Override
    public Completable removeDrink(String drinkId) {
        throw new UnsupportedOperationException("Cache is not available in Remote");
    }

    @Override
    public Completable removeAllDrink() {
        throw new UnsupportedOperationException("Cache is not available in Remote");
    }

    @Override
    public Completable saveDrink(CacheDrinkEntity cacheDrinkEntity) {
        throw new UnsupportedOperationException("Cache is not available in Remote");
    }
}
