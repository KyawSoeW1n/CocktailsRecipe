package com.kurio.cocktail.domain.repository;

import com.kurio.cocktail.domain.model.IngredientDetail;

import java.util.List;

import io.reactivex.Single;

public interface IngredientRepository {
//    Single<IngredientDetail> getIngredientDetail(String ingredientId);

    Single<List<IngredientDetail>> fetchIngredientDetail(String name);
}


