package com.kurio.cocktail.data.remote.mapper;

import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.remote.response.IngredientResponse;
import com.kyawsoewin.mapper.MapperUtils;

import javax.inject.Inject;

public class IngredientDetailResponseMapper implements ResponseMapper<IngredientResponse, IngredientDetailEntity> {

    @Inject
    public IngredientDetailResponseMapper() {

    }

    @Override
    public IngredientDetailEntity mapFromResponse(IngredientResponse response) {
        return MapperUtils.transform(response.data, IngredientDetailEntity.class);
    }
}
