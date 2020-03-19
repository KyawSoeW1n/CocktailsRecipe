package com.kurio.cocktail.domain.repository;

import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;

import java.util.List;

import io.reactivex.Single;

public interface CocktailRepository {
    Single<List<Cocktail>> getAlcoholicDrinks(String route);

    Single<CocktailDetail> getDrinkDetail(String id);
}
