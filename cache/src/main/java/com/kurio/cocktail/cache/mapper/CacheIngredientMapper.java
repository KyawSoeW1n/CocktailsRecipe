package com.kurio.cocktail.cache.mapper;

import com.kurio.cocktail.cache.model.CacheIngredient;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CacheIngredientMapper implements CacheMapper<CacheIngredient, IngredientDetailEntity> {

    @Inject
    public CacheIngredientMapper() {
    }

    @Override
    public IngredientDetailEntity mapFromCached(CacheIngredient cacheIngredient) {
        return MapperUtils.transform(cacheIngredient, IngredientDetailEntity.class);
    }

    @Override
    public CacheIngredient mapToCached(IngredientDetailEntity ingredientDetailEntity) {
        return MapperUtils.transform(ingredientDetailEntity, CacheIngredient.class);
    }
}
