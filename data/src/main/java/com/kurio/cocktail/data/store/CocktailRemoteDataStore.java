package com.kurio.cocktail.data.store;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.repository.CocktailDataStore;
import com.kurio.cocktail.data.repository.CocktailRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class CocktailRemoteDataStore implements CocktailDataStore {

    private CocktailRemote drinkRemote;

    @Inject
    public CocktailRemoteDataStore(CocktailRemote drinkRemote) {
        this.drinkRemote = drinkRemote;
    }

    @Override
    public Single<List<CocktailEntity>> getDrinkList(String route) {
        return drinkRemote.getAlcoholicDrinks(route);
    }

    @Override
    public Single<List<CocktailDetailEntity>> getDrinkDetail(String id) {
        return drinkRemote.getDrinkDetail(id);
    }
}
