package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.repository.IngredientCache;
import com.kurio.cocktail.data.repository.IngredientDataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;


public class IngredientCacheDataStore implements IngredientDataStore {

    private IngredientCache ingredientCache;

    @Inject
    public IngredientCacheDataStore(IngredientCache ingredientCache) {
        this.ingredientCache = ingredientCache;
    }

    @Override
    public Single<List<IngredientDetailEntity>> fetchIngredientDetail(String name) {
        throw new UnsupportedOperationException("Fetch Ingredient Detail is not available in Remote");
    }

    @Override
    public Single<List<CacheIngredientEntity>> getCacheIngredientList() {
        return ingredientCache.getCacheIngredientList();
    }

    @Override
    public Completable removeIngredient(String ingredientId) {
        return ingredientCache.removeIngredient(ingredientId);
    }

    @Override
    public Completable removeAllIngredient() {
        return ingredientCache.removeAllIngredient();
    }

    @Override
    public Single<CacheIngredientEntity> getCacheIngredient(String id) {
        return ingredientCache.getIngredient(id);

    }

    @Override
    public Completable saveIngredient(CacheIngredientEntity cacheIngredientEntity) {
        return ingredientCache.saveIngredient(cacheIngredientEntity);
    }
}