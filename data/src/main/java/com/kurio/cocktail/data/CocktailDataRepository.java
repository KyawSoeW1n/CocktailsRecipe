package com.kurio.cocktail.data;

import com.kurio.cocktail.data.mapper.CocktailDetailMapper;
import com.kurio.cocktail.data.mapper.CocktailListMapper;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.store.CocktailDataStoreFactory;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.domain.repository.CocktailRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class CocktailDataRepository implements CocktailRepository {

    private CocktailListMapper cocktailListMapper;
    private CocktailDetailMapper cocktailDetailMapper;
    private CocktailDataStoreFactory drinkListDataStoreFactory;

    @Inject
    public CocktailDataRepository(CocktailListMapper cocktailListMapper,
                                  CocktailDetailMapper cocktailDetailMapper,
                                  CocktailDataStoreFactory drinkListDataStoreFactory) {
        this.cocktailListMapper = cocktailListMapper;
        this.cocktailDetailMapper = cocktailDetailMapper;
        this.drinkListDataStoreFactory = drinkListDataStoreFactory;

    }

    @Override
    public Single<List<Cocktail>> getAlcoholicDrinks(String route) {
        return drinkListDataStoreFactory.getRemoteDataStore().getDrinkList(route).map(new Function<List<CocktailEntity>, List<Cocktail>>() {
            @Override
            public List<Cocktail> apply(List<CocktailEntity> drinkEntities) throws Exception {
                return cocktailListMapper.mapFromEntity(drinkEntities);
            }
        });
    }

    @Override
    public Single<CocktailDetail> getDrinkDetail(String id) {
        return drinkListDataStoreFactory.getRemoteDataStore().getDrinkDetail(id).map(new Function<CocktailDetailEntity, CocktailDetail>() {
            @Override
            public CocktailDetail apply(CocktailDetailEntity cocktailDetailEntity) throws Exception {
                return cocktailDetailMapper.mapFromEntity(cocktailDetailEntity);
            }
        });
    }
}
