package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.domain.model.IngredientDetail;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IngredientDataStore {
    Single<List<IngredientDetailEntity>> fetchIngredientDetail(String name);

    Single<List<CacheIngredientEntity>> getCacheIngredientList();

    Completable removeIngredient(String ingredientId);

    Completable removeAllIngredient();

    Single<CacheIngredientEntity> getCacheIngredient(String id);

    Completable saveIngredient(CacheIngredientEntity ingredientDetailEntity);

}
