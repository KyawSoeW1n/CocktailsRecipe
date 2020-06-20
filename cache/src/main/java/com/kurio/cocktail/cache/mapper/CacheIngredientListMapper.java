package com.kurio.cocktail.cache.mapper;

import com.kurio.cocktail.cache.model.CacheIngredient;
import com.kurio.cocktail.data.model.CacheIngredientEntity;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CacheIngredientListMapper implements CacheMapper<List<CacheIngredient>, List<CacheIngredientEntity>> {

    @Inject
    public CacheIngredientListMapper() {
    }

    @Override
    public List<CacheIngredientEntity> mapFromCached(List<CacheIngredient> cacheDrink) {
        return Arrays.asList(MapperUtils.transform(cacheDrink, CacheIngredientEntity[].class));
    }

    @Override
    public List<CacheIngredient> mapToCached(List<CacheIngredientEntity> cacheDrinkEntity) {
        return Arrays.asList(MapperUtils.transform(cacheDrinkEntity, CacheIngredient[].class));
    }
}
