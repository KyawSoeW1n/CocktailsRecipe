package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.repository.CocktailDataStore;
import com.kurio.cocktail.data.repository.CocktailRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class CocktailRemoteDataStore implements CocktailDataStore {

    private CocktailRemote cocktailRemote;

    @Inject
    public CocktailRemoteDataStore(CocktailRemote drinkRemote) {
        this.cocktailRemote = drinkRemote;
    }

    @Override
    public Single<List<CocktailEntity>> getDrinkList(String route) {
        return cocktailRemote.getAlcoholicDrinks(route);
    }

    @Override
    public Single<CocktailDetailEntity> getDrinkDetail(String id) {
        return cocktailRemote.getDrinkDetail(id);
    }

    @Override
    public Single<IngredientDetailEntity> getIngredientDetail(String name) {
        return cocktailRemote.getIngredientDetail(name);
    }
}
