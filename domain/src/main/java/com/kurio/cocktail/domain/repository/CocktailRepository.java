package com.kurio.cocktail.domain.repository;

import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.model.IngredientDetail;

import java.util.List;

import io.reactivex.Single;

public interface CocktailRepository {
    Single<List<Cocktail>> getAlcoholicDrinks(String route);

    Single<List<CocktailDetail>> getDrinkDetail(String id);

    Single<List<IngredientDetail>> getIngredientDetail(String name);
}
