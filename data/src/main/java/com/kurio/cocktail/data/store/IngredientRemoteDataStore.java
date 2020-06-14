package com.kurio.cocktail.data.store;

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
        return null;
    }

    @Override
    public Completable removeIngredient(String ingredientId) {
        return null;
    }

    @Override
    public Completable removeAllIngredient() {
        return null;
    }

    @Override
    public Completable saveIngredient(IngredientDetailEntity ingredientDetailEntity) {
        return null;
    }
}
