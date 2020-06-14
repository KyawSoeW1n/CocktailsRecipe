package com.kurio.cocktail.data.remote.mapper;

import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.remote.response.IngredientResponse;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class IngredientDetailResponseMapper implements ResponseMapper<IngredientResponse, List<IngredientDetailEntity>> {

    @Inject
    public IngredientDetailResponseMapper() {

    }

    @Override
    public List<IngredientDetailEntity> mapFromResponse(IngredientResponse response) {
        return Arrays.asList(MapperUtils.transform(response.data, IngredientDetailEntity[].class));
    }
}
