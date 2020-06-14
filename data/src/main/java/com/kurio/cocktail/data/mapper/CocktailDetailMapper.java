package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CocktailDetailMapper implements EntityMapper<List<CocktailDetailEntity>, List<CocktailDetail>> {

    @Inject
    public CocktailDetailMapper() {
    }

    @Override
    public List<CocktailDetail> mapFromEntity(List<CocktailDetailEntity> cocktailDetailEntity) {
        return Arrays.asList(MapperUtils.transform(cocktailDetailEntity, CocktailDetail[].class));
    }

    @Override
    public List<CocktailDetailEntity> mapToEntity(List<CocktailDetail> cocktailDetail) {
        return Arrays.asList(MapperUtils.transform(cocktailDetail, CocktailDetailEntity[].class));
    }
}