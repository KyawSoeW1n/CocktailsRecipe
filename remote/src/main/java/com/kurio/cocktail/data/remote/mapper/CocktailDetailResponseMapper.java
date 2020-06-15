package com.kurio.cocktail.data.remote.mapper;

import com.kurio.cocktail.data.model.DrinkDetailEntity;
import com.kurio.cocktail.data.remote.response.DrinkResponse;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class CocktailDetailResponseMapper implements ResponseMapper<DrinkResponse, List<DrinkDetailEntity>> {

    @Inject
    public CocktailDetailResponseMapper() {

    }

    @Override
    public List<DrinkDetailEntity> mapFromResponse(DrinkResponse response) {
        return Arrays.asList(MapperUtils.transform(response.data, DrinkDetailEntity[].class));
    }
}
