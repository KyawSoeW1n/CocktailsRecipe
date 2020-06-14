package com.kurio.cocktail.data;

import com.kurio.cocktail.data.mapper.CacheDrinkDataMapper;
import com.kurio.cocktail.data.mapper.CocktailDetailMapper;
import com.kurio.cocktail.data.mapper.CocktailListMapper;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.store.DrinkDataStoreFactory;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.repository.DrinkRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class DrinkDataRepository implements DrinkRepository {
    private CocktailListMapper cocktailListMapper;
    private CocktailDetailMapper cocktailDetailMapper;
    private DrinkDataStoreFactory drinkDataStoreFactory;
    private CacheDrinkDataMapper cacheDrinkDataMapper;

    @Inject
    public DrinkDataRepository(CocktailListMapper cocktailListMapper,
                               CocktailDetailMapper cocktailDetailMapper,
                               DrinkDataStoreFactory drinkDataStoreFactory,
                               CacheDrinkDataMapper cacheDrinkDataMapper) {
        this.cocktailListMapper = cocktailListMapper;
        this.cocktailDetailMapper = cocktailDetailMapper;
        this.drinkDataStoreFactory = drinkDataStoreFactory;
        this.cacheDrinkDataMapper = cacheDrinkDataMapper;
    }

    @Override
    public Single<List<Cocktail>> getAlcoholicDrinks(String route) {
        return drinkDataStoreFactory.getDrinkRemoteDataStore().fetchDrink(route).map(new Function<List<CocktailEntity>, List<Cocktail>>() {
            @Override
            public List<Cocktail> apply(List<CocktailEntity> drinkEntities) throws Exception {
                return cocktailListMapper.mapFromEntity(drinkEntities);
            }
        });
    }

    @Override
    public Single<List<CocktailDetail>> fetchDrinkDetail(String id) {
        return drinkDataStoreFactory.getDrinkRemoteDataStore().fetchDrinkDetail(id)
                .map(new Function<List<CocktailDetailEntity>, List<CocktailDetail>>() {
                    @Override
                    public List<CocktailDetail> apply(List<CocktailDetailEntity> cocktailDetailEntity) throws Exception {
                        return cocktailDetailMapper.mapFromEntity(cocktailDetailEntity);
                    }
                });
    }

    @Override
    public Single<CacheDrink> getDrinkDetail(String id) {
        return null;
    }

    @Override
    public Completable saveDrink(CacheDrink drink) {
        return drinkDataStoreFactory.getDrinkCacheDataStore().saveDrink(cacheDrinkDataMapper.mapToEntity(drink));
    }


}
