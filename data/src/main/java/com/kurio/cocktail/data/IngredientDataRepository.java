package com.kurio.cocktail.data;

import com.kurio.cocktail.data.mapper.IngredientDetailMapper;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.store.IngredientDataStoreFactory;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.domain.repository.IngredientRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class IngredientDataRepository implements IngredientRepository {
    private IngredientDetailMapper ingredientDetailMapper;
    private IngredientDataStoreFactory ingredientDataStoreFactory;

    @Inject
    public IngredientDataRepository(IngredientDetailMapper ingredientDetailMapper,
                                    IngredientDataStoreFactory ingredientDataStoreFactory) {
        this.ingredientDataStoreFactory = ingredientDataStoreFactory;
        this.ingredientDetailMapper = ingredientDetailMapper;

    }

    @Override
    public Single<IngredientDetail> getIngredientDetail(String name) {
//        return ingredientDataStoreFactory.getRemoteDataStore().getIngredientDetail(name)
//                .map(new Function<List<IngredientDetailEntity>, IngredientDetail>() {
//                    @Override
//                    public IngredientDetail apply(List<IngredientDetailEntity> ingredientDetailEntities) throws Exception {
//                        return ingredientDetailMapper.mapFromEntity();
//                    }
//                });

        return null;
    }

    @Override
    public Single<List<IngredientDetail>> fetchIngredientDetail(String name) {
        return ingredientDataStoreFactory.getRemoteDataStore().fetchIngredientDetail(name)
                .map(new Function<List<IngredientDetailEntity>, List<IngredientDetail>>() {
                    @Override
                    public List<IngredientDetail> apply(List<IngredientDetailEntity> ingredientDetailEntity) throws Exception {
                        return ingredientDetailMapper.mapFromEntity(ingredientDetailEntity);
                    }
                });
    }
}
