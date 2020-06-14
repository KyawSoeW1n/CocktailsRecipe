package com.kurio.cocktail.cache;

import com.kurio.cocktail.cache.db.CocktailDatabase;
import com.kurio.cocktail.cache.mapper.CacheDrinkListMapper;
import com.kurio.cocktail.cache.mapper.CacheDrinkMapper;
import com.kurio.cocktail.cache.model.CacheDrink;
import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.repository.DrinkCache;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class CacheDrinkImpl implements DrinkCache {

    private CocktailDatabase cocktailDatabase;
    private CacheDrinkListMapper cacheDrinkListMapper;
    private CacheDrinkMapper cacheDrinkMapper;


    @Inject
    public CacheDrinkImpl(CocktailDatabase cocktailDatabase,
                           CacheDrinkListMapper cacheDrinkListMapper,
                           CacheDrinkMapper cacheDrinkMapper) {
        this.cocktailDatabase = cocktailDatabase;
        this.cacheDrinkMapper = cacheDrinkMapper;
        this.cacheDrinkListMapper = cacheDrinkListMapper;
    }

    @Override
    public Single<List<CacheDrinkEntity>> getCacheDrinkList() {
        return cocktailDatabase.cachedDrinkDao().getCachedDrinkList()
                .map(new Function<List<CacheDrink>, List<CacheDrinkEntity>>() {
                    @Override
                    public List<CacheDrinkEntity> apply(List<CacheDrink> cacheDrinks) throws Exception {
                        return cacheDrinkListMapper.mapFromCached(cacheDrinks);
                    }
                });
    }

    @Override
    public Completable removeDrink(String drinkId) {
        cocktailDatabase.cachedDrinkDao().deleteDrink(drinkId);
        return Completable.complete();
    }

    @Override
    public Completable removeAllDrink() {
        cocktailDatabase.cachedDrinkDao().deleteAllDrink();
        return Completable.complete();
    }

    @Override
    public Completable saveDrink(CacheDrinkEntity cacheDrinkEntity) {
        cocktailDatabase.cachedDrinkDao().saveDrink(cacheDrinkMapper.mapToCached(cacheDrinkEntity));
        return Completable.complete();
    }
}
