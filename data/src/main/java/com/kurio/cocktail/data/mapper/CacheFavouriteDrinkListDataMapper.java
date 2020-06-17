package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CacheDrinkEntity;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CacheFavouriteDrinkListDataMapper implements EntityMapper<List<CacheDrinkEntity>, List<CacheDrink>> {

    @Inject
    public CacheFavouriteDrinkListDataMapper() {
    }


    @Override
    public List<CacheDrink> mapFromEntity(List<CacheDrinkEntity> entity) {
        return Arrays.asList(MapperUtils.transform(entity, CacheDrink[].class));
    }

    @Override
    public List<CacheDrinkEntity> mapToEntity(List<CacheDrink> entity) {
        return Arrays.asList(MapperUtils.transform(entity, CacheDrinkEntity[].class));
    }
}