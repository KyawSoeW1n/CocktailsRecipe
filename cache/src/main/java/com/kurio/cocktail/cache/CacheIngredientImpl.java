package com.kurio.cocktail.cache;

import com.kurio.cocktail.cache.db.CocktailDatabase;
import com.kurio.cocktail.cache.mapper.CacheDrinkListMapper;
import com.kurio.cocktail.cache.mapper.CacheDrinkMapper;
import com.kurio.cocktail.cache.mapper.CacheIngredientListMapper;
import com.kurio.cocktail.cache.mapper.CacheIngredientMapper;
import com.kurio.cocktail.cache.model.CacheDrink;
import com.kurio.cocktail.cache.model.CacheIngredient;
import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.repository.DrinkCache;
import com.kurio.cocktail.data.repository.IngredientCache;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class CacheIngredientImpl implements IngredientCache {

    private CocktailDatabase cocktailDatabase;
    private CacheIngredientListMapper cacheIngredientListMapper;
    private CacheIngredientMapper cacheIngredientMapper;


    @Inject
    public CacheIngredientImpl(CocktailDatabase cocktailDatabase,
                               CacheIngredientListMapper cacheIngredientListMapper,
                               CacheIngredientMapper cacheIngredientMapper) {
        this.cocktailDatabase = cocktailDatabase;
        this.cacheIngredientListMapper = cacheIngredientListMapper;
        this.cacheIngredientMapper = cacheIngredientMapper;
    }

    @Override
    public Single<List<IngredientDetailEntity>> getCacheIngredientList() {
        return cocktailDatabase.cachedIngredientDao().getCachedIngredientList()
                .map(new Function<List<CacheIngredient>, List<IngredientDetailEntity>>() {
                    @Override
                    public List<IngredientDetailEntity> apply(List<CacheIngredient> cacheDrinks) throws Exception {
                        return cacheIngredientListMapper.mapFromCached(cacheDrinks);
                    }
                });
    }

    @Override
    public Completable removeIngredient(String ingredientId) {
        cocktailDatabase.cachedDrinkDao().deleteDrink(ingredientId);
        return Completable.complete();
    }

    @Override
    public Completable removeAllIngredient() {
        cocktailDatabase.cachedIngredientDao().deleteAllIngredient();
        return Completable.complete();
    }

    @Override
    public Completable saveIngredient(IngredientDetailEntity ingredientDetailEntity) {
        cocktailDatabase.cachedIngredientDao().saveIngredient(cacheIngredientMapper.mapToCached(ingredientDetailEntity));
        return Completable.complete();
    }
}
