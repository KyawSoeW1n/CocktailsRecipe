package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.DrinkDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;

import java.util.List;

import io.reactivex.Single;

public interface DrinkRemote {
    Single<List<CocktailEntity>> getAlcoholicDrinks(String route);

    Single<List<DrinkDetailEntity>> getDrinkDetail(String id);
}
