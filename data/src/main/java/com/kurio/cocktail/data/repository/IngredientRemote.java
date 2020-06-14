package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.IngredientDetailEntity;

import java.util.List;

import io.reactivex.Single;

public interface IngredientRemote {
    Single<List<IngredientDetailEntity>> getIngredientDetail(String name);
}
