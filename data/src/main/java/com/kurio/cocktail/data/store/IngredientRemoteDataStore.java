package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.repository.IngredientDataStore;
import com.kurio.cocktail.data.repository.IngredientRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class IngredientRemoteDataStore implements IngredientDataStore {

    private IngredientRemote ingredientRemote;

    @Inject
    public IngredientRemoteDataStore(IngredientRemote ingredientRemote) {
        this.ingredientRemote = ingredientRemote;
    }

    @Override
    public Single<List<IngredientDetailEntity>> fetchIngredientDetail(String name) {
        return ingredientRemote.getIngredientDetail(name);
    }

    @Override
    public Single<List<IngredientDetailEntity>> getCacheIngredientList() {
        throw new UnsupportedOperationException("Cache Ingredient Detail is not available in Remote");
    }

    @Override
    public Completable removeIngredient(String ingredientId) {
        throw new UnsupportedOperationException("Cache Ingredient Detail is not available in Remote");
    }

    @Override
    public Completable removeAllIngredient() {
        return null;
    }

    @Override
    public Single<CacheIngredientEntity> getCacheIngredient(String id) {
        throw new UnsupportedOperationException("Cache Ingredient Detail is not available in Remote");
    }

    @Override
    public Completable saveIngredient(CacheIngredientEntity ingredientDetailEntity) {
        throw new UnsupportedOperationException("Cache Ingredient Detail is not available in Remote");
    }
}
