package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.CacheDrinkEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface DrinkCache {
    Flowable<List<CacheDrinkEntity>> getCacheDrinkList();

    Completable removeDrink(String drinkId);

    Single<CacheDrinkEntity> getDrink(String drinkId);

    Completable removeAllDrink();

    Completable saveDrink(CacheDrinkEntity cacheDrinkEntity);
}
