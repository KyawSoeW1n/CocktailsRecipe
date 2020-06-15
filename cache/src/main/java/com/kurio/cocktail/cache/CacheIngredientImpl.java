package com.kurio.cocktail.cache;

import com.kurio.cocktail.cache.db.CocktailDatabase;
import com.kurio.cocktail.cache.mapper.CacheIngredientListMapper;
import com.kurio.cocktail.cache.mapper.CacheIngredientMapper;
import com.kurio.cocktail.cache.model.CacheIngredient;
import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.repository.IngredientCache;

import java.util.List;
import java.util.concurrent.Callable;

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
    public Single<CacheIngredientEntity> getIngredient(String ingredientId) {
        return cocktailDatabase.cachedIngredientDao().getIngredient(ingredientId)
                .map(new Function<CacheIngredient, CacheIngredientEntity>() {
                    @Override
                    public CacheIngredientEntity apply(CacheIngredient cacheIngredient) throws Exception {
                        return cacheIngredientMapper.mapFromCached(cacheIngredient);
                    }
                });
    }

    @Override
    public Completable removeIngredient(final String ingredientId) {
        return Completable.fromCallable(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                cocktailDatabase.cachedIngredientDao().deleteIngredient(ingredientId);
                return Completable.complete();
            }
        });

    }

    @Override
    public Completable removeAllIngredient() {
        cocktailDatabase.cachedIngredientDao().deleteAllIngredient();
        return Completable.complete();
    }

    @Override
    public Completable saveIngredient(final CacheIngredientEntity cacheIngredientEntity) {
        return Completable.fromCallable(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                cocktailDatabase.cachedIngredientDao().saveIngredient(cacheIngredientMapper.mapToCached(cacheIngredientEntity));
                return Completable.complete();
            }
        });
    }
}
