package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.DrinkDetailEntity;
import com.kurio.cocktail.domain.model.DrinkDetail;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class DrinkDetailMapper implements EntityMapper<List<DrinkDetailEntity>, List<DrinkDetail>> {

    @Inject
    public DrinkDetailMapper() {
    }

    @Override
    public List<DrinkDetail> mapFromEntity(List<DrinkDetailEntity> cocktailDetailEntity) {
        return Arrays.asList(MapperUtils.transform(cocktailDetailEntity, DrinkDetail[].class));
    }

    @Override
    public List<DrinkDetailEntity> mapToEntity(List<DrinkDetail> cocktailDetail) {
        return Arrays.asList(MapperUtils.transform(cocktailDetail, DrinkDetailEntity[].class));
    }
}