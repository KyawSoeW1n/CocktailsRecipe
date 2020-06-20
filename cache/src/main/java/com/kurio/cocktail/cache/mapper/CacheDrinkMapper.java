package com.kurio.cocktail.cache.mapper;

import com.kurio.cocktail.cache.model.CacheDrink;
import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CacheDrinkMapper implements CacheMapper<CacheDrink, CacheDrinkEntity> {

    @Inject
    public CacheDrinkMapper() {
    }

    @Override
    public CacheDrinkEntity mapFromCached(CacheDrink cacheDrink) {
        return MapperUtils.transform(cacheDrink, CacheDrinkEntity.class);
    }

    @Override
    public CacheDrink mapToCached(CacheDrinkEntity cacheDrinkEntity) {
        return MapperUtils.transform(cacheDrinkEntity, CacheDrink.class);
    }
}
