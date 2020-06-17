package com.kurio.cocktail.data;

import com.kurio.cocktail.data.mapper.CacheFavouriteIngredientListDataMapper;
import com.kurio.cocktail.data.mapper.CacheIngredientDetailMapper;
import com.kurio.cocktail.data.mapper.IngredientDetailMapper;
import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.store.IngredientDataStoreFactory;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class IngredientDataRepository implements IngredientRepository {
    private IngredientDetailMapper ingredientDetailMapper;
    private CacheIngredientDetailMapper cacheIngredientDetailMapper;
    private IngredientDataStoreFactory ingredientDataStoreFactory;
    private CacheFavouriteIngredientListDataMapper cacheFavouriteIngredientListDataMapper;

    @Inject
    public IngredientDataRepository(IngredientDetailMapper ingredientDetailMapper,
                                    CacheIngredientDetailMapper cacheIngredientDetailMapper,
                                    IngredientDataStoreFactory ingredientDataStoreFactory,
                                    CacheFavouriteIngredientListDataMapper cacheFavouriteIngredientListDataMapper) {
        this.ingredientDataStoreFactory = ingredientDataStoreFactory;
        this.ingredientDetailMapper = ingredientDetailMapper;
        this.cacheIngredientDetailMapper = cacheIngredientDetailMapper;
        this.cacheFavouriteIngredientListDataMapper = cacheFavouriteIngredientListDataMapper;
    }


    @Override
    public Single<List<CacheIngredient>> getFavouriteIngredientList() {
        return ingredientDataStoreFactory.getIngredientCacheDataStore().getCacheIngredientList()
                .map(new Function<List<CacheIngredientEntity>, List<CacheIngredient>>() {
                    @Override
                    public List<CacheIngredient> apply(List<CacheIngredientEntity> cacheIngredientEntities) throws Exception {
                        return cacheFavouriteIngredientListDataMapper.mapFromEntity(cacheIngredientEntities);
                    }
                });
    }

    @Override
    public Single<CacheIngredient> getIngredientDetail(String id) {
        return ingredientDataStoreFactory.getIngredientCacheDataStore().getCacheIngredient(id)
                .map(new Function<CacheIngredientEntity, CacheIngredient>() {
                    @Override
                    public CacheIngredient apply(CacheIngredientEntity cacheIngredientEntity) throws Exception {
                        return cacheIngredientDetailMapper.mapFromEntity(cacheIngredientEntity);
                    }
                });
    }


    @Override
    public Completable deleteIngredientDetail(String id) {
        return ingredientDataStoreFactory.getIngredientCacheDataStore().removeIngredient(id);
    }

    @Override
    public Completable saveIngredient(CacheIngredient cacheIngredient) {
        return ingredientDataStoreFactory.getIngredientCacheDataStore().saveIngredient(cacheIngredientDetailMapper.mapToEntity(cacheIngredient));
    }

    @Override
    public Single<List<IngredientDetail>> fetchIngredientDetail(String name) {
        return ingredientDataStoreFactory.getIngredientRemoteDataStore().fetchIngredientDetail(name)
                .map(new Function<List<IngredientDetailEntity>, List<IngredientDetail>>() {
                    @Override
                    public List<IngredientDetail> apply(List<IngredientDetailEntity> ingredientDetailEntity) throws Exception {
                        return ingredientDetailMapper.mapFromEntity(ingredientDetailEntity);
                    }
                });
    }
}
