package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CacheFavouriteIngredientListDataMapper implements EntityMapper<List<CacheIngredientEntity>, List<CacheIngredient>> {
    @Inject
    public CacheFavouriteIngredientListDataMapper() {
    }

    @Override
    public List<CacheIngredient> mapFromEntity(List<CacheIngredientEntity> entity) {
        return Arrays.asList(MapperUtils.transform(entity, CacheIngredient[].class));
    }

    @Override
    public List<CacheIngredientEntity> mapToEntity(List<CacheIngredient> entity) {
        return Arrays.asList(MapperUtils.transform(entity, CacheIngredientEntity[].class));
    }
}
