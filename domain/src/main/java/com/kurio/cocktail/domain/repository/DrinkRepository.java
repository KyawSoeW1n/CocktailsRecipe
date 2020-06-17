package com.kurio.cocktail.domain.repository;

import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.Drink;
import com.kurio.cocktail.domain.model.DrinkDetail;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DrinkRepository {
    Single<List<Drink>> fetchDrink(String route);

    Single<List<DrinkDetail>> fetchDrinkDetail(String id);

    Single<CacheDrink> getDrinkDetail(String id);

    Single<List<CacheDrink>> getFavouriteDrink();

    Completable deleteDrinkDetail(String id);

    Completable deleteDrinkAll();

    Completable saveDrink(CacheDrink drink);
}
