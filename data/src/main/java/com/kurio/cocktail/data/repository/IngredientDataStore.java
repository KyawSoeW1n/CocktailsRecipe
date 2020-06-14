package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.IngredientDetailEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IngredientDataStore {
    Single<List<IngredientDetailEntity>> fetchIngredientDetail(String name);

    Single<List<IngredientDetailEntity>> getCacheIngredientList();

    Completable removeIngredient(String ingredientId);

    Completable removeAllIngredient();

    Completable saveIngredient(IngredientDetailEntity ingredientDetailEntity);

}
