package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.domain.model.Drink;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CocktailListMapper implements EntityMapper<List<CocktailEntity>, List<Drink>> {

    @Inject
    public CocktailListMapper() {
    }

    @Override
    public List<Drink> mapFromEntity(List<CocktailEntity> entity) {
        return Arrays.asList(MapperUtils.transform(entity, Drink[].class));
    }

    @Override
    public List<CocktailEntity> mapToEntity(List<Drink> cocktails) {
        return Arrays.asList(MapperUtils.transform(cocktails, CocktailEntity[].class));
    }

}
