package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IngredientCache {

    Single<List<CacheIngredientEntity>> getCacheIngredientList();

    Single<CacheIngredientEntity> getIngredient(String ingredientId);

    Completable removeIngredient(String ingredientId);

    Completable removeAllIngredient();

    Completable saveIngredient(CacheIngredientEntity cacheIngredientEntity);
}
