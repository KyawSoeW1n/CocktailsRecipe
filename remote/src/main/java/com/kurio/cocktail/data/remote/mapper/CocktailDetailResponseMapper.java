package com.kurio.cocktail.data.remote.mapper;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.remote.response.DrinkResponse;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class CocktailDetailResponseMapper implements ResponseMapper<DrinkResponse, CocktailDetailEntity> {

    @Inject
    public CocktailDetailResponseMapper() {

    }

    @Override
    public CocktailDetailEntity mapFromResponse(DrinkResponse response) {
        return MapperUtils.transform(response.data, CocktailDetailEntity.class);

    }
}
