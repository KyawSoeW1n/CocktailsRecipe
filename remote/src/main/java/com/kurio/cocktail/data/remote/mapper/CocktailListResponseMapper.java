package com.kurio.cocktail.data.remote.mapper;

import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.remote.response.DrinkResponse;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CocktailListResponseMapper implements ResponseMapper<DrinkResponse, List<CocktailEntity>> {

    @Inject
    public CocktailListResponseMapper() {

    }

    @Override
    public List<CocktailEntity> mapFromResponse(DrinkResponse response) {
        return Arrays.asList(MapperUtils.transform(response.data, CocktailEntity[].class));
    }
}
