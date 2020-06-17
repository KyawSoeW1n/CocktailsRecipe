package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CacheIngredientDetailMapper implements EntityMapper<CacheIngredientEntity, CacheIngredient> {

    @Inject
    public CacheIngredientDetailMapper() {
    }

    @Override
    public CacheIngredient mapFromEntity(CacheIngredientEntity entity) {
        return MapperUtils.transform(entity, CacheIngredient.class);
    }

    @Override
    public CacheIngredientEntity mapToEntity(CacheIngredient entity) {
        return MapperUtils.transform(entity, CacheIngredientEntity.class);
    }
}
