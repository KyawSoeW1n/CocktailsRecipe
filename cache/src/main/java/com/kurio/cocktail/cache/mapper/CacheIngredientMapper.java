package com.kurio.cocktail.cache.mapper;

import com.kurio.cocktail.cache.model.CacheIngredient;
import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CacheIngredientMapper implements CacheMapper<CacheIngredient, CacheIngredientEntity> {

    @Inject
    public CacheIngredientMapper() {
    }

    @Override
    public CacheIngredientEntity mapFromCached(CacheIngredient cacheIngredient) {
        return MapperUtils.transform(cacheIngredient, CacheIngredientEntity.class);
    }

    @Override
    public CacheIngredient mapToCached(CacheIngredientEntity cacheIngredientEntity) {
        return MapperUtils.transform(cacheIngredientEntity, CacheIngredient.class);
    }
}
