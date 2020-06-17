package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.model.DrinkDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DrinkDataStore {
    Single<List<CocktailEntity>> fetchDrink(String route);

    Single<List<DrinkDetailEntity>> fetchDrinkDetail(String id);

    Single<List<CacheDrinkEntity>> getCacheDrinkList();

    Single<CacheDrinkEntity> getCacheDrink(String id);

    Completable removeDrink(String drinkId);

    Completable removeAllDrink();

    Completable saveDrink(CacheDrinkEntity cacheDrinkEntity);

}
