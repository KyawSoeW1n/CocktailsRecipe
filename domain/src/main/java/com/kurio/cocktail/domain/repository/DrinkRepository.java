package com.kurio.cocktail.domain.repository;

import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DrinkRepository {
    Single<List<Cocktail>> getAlcoholicDrinks(String route);

    Single<List<CocktailDetail>> fetchDrinkDetail(String id);

    Single<CacheDrink> getDrinkDetail(String id);

    Completable saveDrink(CacheDrink drink);
}
