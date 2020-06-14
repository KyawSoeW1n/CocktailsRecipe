package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CacheDrinkDataMapper implements EntityMapper<CacheDrinkEntity, CacheDrink> {

    @Inject
    public CacheDrinkDataMapper() {
    }


    @Override
    public CacheDrink mapFromEntity(CacheDrinkEntity entity) {
        return MapperUtils.transform(entity, CacheDrink.class);
    }

    @Override
    public CacheDrinkEntity mapToEntity(CacheDrink entity) {
        return MapperUtils.transform(entity, CacheDrinkEntity.class);
    }
}