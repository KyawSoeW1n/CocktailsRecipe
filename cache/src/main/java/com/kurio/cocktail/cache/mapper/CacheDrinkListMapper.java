package com.kurio.cocktail.cache.mapper;

import com.kurio.cocktail.cache.model.CacheDrink;
import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CacheDrinkListMapper implements CacheMapper<List<CacheDrink>, List<CacheDrinkEntity>> {

    @Inject
    public CacheDrinkListMapper() {
    }

    @Override
    public List<CacheDrinkEntity> mapFromCached(List<CacheDrink> cacheDrink) {
        return Arrays.asList(MapperUtils.transform(cacheDrink, CacheDrinkEntity[].class));
    }

    @Override
    public List<CacheDrink> mapToCached(List<CacheDrinkEntity> cacheDrinkEntity) {
        return Arrays.asList(MapperUtils.transform(cacheDrinkEntity, CacheDrink[].class));
    }
}
