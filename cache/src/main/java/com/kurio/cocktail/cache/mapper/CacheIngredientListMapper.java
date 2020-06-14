package com.kurio.cocktail.cache.mapper;

import com.kurio.cocktail.cache.model.CacheIngredient;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class CacheIngredientListMapper implements CacheMapper<List<CacheIngredient>, List<IngredientDetailEntity>> {

    @Inject
    public CacheIngredientListMapper() {
    }

    @Override
    public List<IngredientDetailEntity> mapFromCached(List<CacheIngredient> cacheDrink) {
        return Collections.singletonList(MapperUtils.transform(cacheDrink, IngredientDetailEntity.class));
    }

    @Override
    public List<CacheIngredient> mapToCached(List<IngredientDetailEntity> cacheDrinkEntity) {
        return Collections.singletonList(MapperUtils.transform(cacheDrinkEntity, CacheIngredient.class));
    }
}
