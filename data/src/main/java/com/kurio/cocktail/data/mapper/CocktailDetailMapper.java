package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.domain.model.DrinkDetail;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CocktailDetailMapper implements EntityMapper<List<CocktailDetailEntity>, List<DrinkDetail>> {

    @Inject
    public CocktailDetailMapper() {
    }

    @Override
    public List<DrinkDetail> mapFromEntity(List<CocktailDetailEntity> cocktailDetailEntity) {
        return Arrays.asList(MapperUtils.transform(cocktailDetailEntity, DrinkDetail[].class));
    }

    @Override
    public List<CocktailDetailEntity> mapToEntity(List<DrinkDetail> cocktailDetail) {
        return Arrays.asList(MapperUtils.transform(cocktailDetail, CocktailDetailEntity[].class));
    }
}