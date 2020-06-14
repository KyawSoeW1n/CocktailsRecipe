package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CocktailListMapper implements EntityMapper<List<CocktailEntity>, List<Cocktail>> {

    @Inject
    public CocktailListMapper() {
    }

    @Override
    public List<Cocktail> mapFromEntity(List<CocktailEntity> entity) {
        return Arrays.asList(MapperUtils.transform(entity, Cocktail[].class));
    }

    @Override
    public List<CocktailEntity> mapToEntity(List<Cocktail> cocktails) {
        return Arrays.asList(MapperUtils.transform(cocktails, CocktailEntity[].class));
    }

}
