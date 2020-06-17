package com.kurio.cocktail.data;

import com.kurio.cocktail.data.mapper.CacheDrinkDataMapper;
import com.kurio.cocktail.data.mapper.CacheFavouriteDrinkListDataMapper;
import com.kurio.cocktail.data.mapper.CocktailListMapper;
import com.kurio.cocktail.data.mapper.DrinkDetailMapper;
import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.model.DrinkDetailEntity;
import com.kurio.cocktail.data.store.DrinkDataStoreFactory;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.Drink;
import com.kurio.cocktail.domain.model.DrinkDetail;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class DrinkDataRepository implements DrinkRepository {
    private CocktailListMapper cocktailListMapper;
    private DrinkDetailMapper drinkDetailMapper;
    private DrinkDataStoreFactory drinkDataStoreFactory;
    private CacheDrinkDataMapper cacheDrinkDataMapper;
    private CacheFavouriteDrinkListDataMapper cacheFavouriteDrinkListDataMapper;

    @Inject
    public DrinkDataRepository(CocktailListMapper cocktailListMapper,
                               DrinkDetailMapper drinkDetailMapper,
                               DrinkDataStoreFactory drinkDataStoreFactory,
                               CacheDrinkDataMapper cacheDrinkDataMapper,
                               CacheFavouriteDrinkListDataMapper cacheFavouriteDrinkListDataMapper) {
        this.cocktailListMapper = cocktailListMapper;
        this.drinkDetailMapper = drinkDetailMapper;
        this.drinkDataStoreFactory = drinkDataStoreFactory;
        this.cacheDrinkDataMapper = cacheDrinkDataMapper;
        this.cacheFavouriteDrinkListDataMapper = cacheFavouriteDrinkListDataMapper;
    }

    @Override
    public Single<List<Drink>> fetchDrink(String route) {
        return drinkDataStoreFactory.getDrinkRemoteDataStore().fetchDrink(route).map(new Function<List<CocktailEntity>, List<Drink>>() {
            @Override
            public List<Drink> apply(List<CocktailEntity> drinkEntities) throws Exception {
                return cocktailListMapper.mapFromEntity(drinkEntities);
            }
        });
    }

    @Override
    public Single<List<DrinkDetail>> fetchDrinkDetail(String id) {
        return drinkDataStoreFactory.getDrinkRemoteDataStore().fetchDrinkDetail(id)
                .map(new Function<List<DrinkDetailEntity>, List<DrinkDetail>>() {
                    @Override
                    public List<DrinkDetail> apply(List<DrinkDetailEntity> cocktailDetailEntity) throws Exception {
                        return drinkDetailMapper.mapFromEntity(cocktailDetailEntity);
                    }
                });
    }

    @Override
    public Single<CacheDrink> getDrinkDetail(String id) {
        return drinkDataStoreFactory.getDrinkCacheDataStore().getCacheDrink(id)
                .map(new Function<CacheDrinkEntity, CacheDrink>() {
                    @Override
                    public CacheDrink apply(CacheDrinkEntity cacheDrinkEntity) throws Exception {
                        return cacheDrinkDataMapper.mapFromEntity(cacheDrinkEntity);
                    }
                });
    }

    @Override
    public Single<List<CacheDrink>> getFavouriteDrink() {
        return drinkDataStoreFactory.getDrinkCacheDataStore().getCacheDrinkList()
                .map(new Function<List<CacheDrinkEntity>, List<CacheDrink>>() {
                    @Override
                    public List<CacheDrink> apply(List<CacheDrinkEntity> cacheDrinkEntities) throws Exception {
                        return cacheFavouriteDrinkListDataMapper.mapFromEntity(cacheDrinkEntities);
                    }
                });
    }

    @Override
    public Completable deleteDrinkDetail(String id) {
        return drinkDataStoreFactory.getDrinkCacheDataStore().removeDrink(id);
    }

    @Override
    public Completable deleteDrinkAll() {
        return drinkDataStoreFactory.getDrinkCacheDataStore().removeAllDrink();
    }

    @Override
    public Completable saveDrink(CacheDrink drink) {
        return drinkDataStoreFactory.getDrinkCacheDataStore().saveDrink(cacheDrinkDataMapper.mapToEntity(drink));
    }


}
