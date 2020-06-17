package com.kurio.cocktail.domain.repository;

import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.domain.model.IngredientDetail;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IngredientRepository {
    Single<List<CacheIngredient>> getFavouriteIngredientList();

    Single<CacheIngredient> getIngredientDetail(String id);

    Completable deleteIngredientDetail(String id);

    Completable saveIngredient(CacheIngredient cacheIngredient);

    Completable deleteAllIngredient();

    Single<List<IngredientDetail>> fetchIngredientDetail(String name);
}


