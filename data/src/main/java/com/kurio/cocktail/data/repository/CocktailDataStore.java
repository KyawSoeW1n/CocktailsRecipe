package com.kurio.cocktail.data.repository;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;

import java.util.List;

import io.reactivex.Single;

public interface CocktailDataStore {
    Single<List<CocktailEntity>> getDrinkList(String route);

    Single<CocktailDetailEntity> getDrinkDetail(String id);

}
