package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;

import java.util.List;

import io.reactivex.Single;

public interface CocktailRemote {
    Single<List<CocktailEntity>> getAlcoholicDrinks(String route);

    Single<List<CocktailDetailEntity>> getDrinkDetail(String id);

    Single<List<IngredientDetailEntity>> getIngredientDetail(String name);


}