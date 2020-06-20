package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kyawsoewin.mapper.MapperUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class IngredientDetailMapper implements EntityMapper<List<IngredientDetailEntity>, List<IngredientDetail>> {

    @Inject
    public IngredientDetailMapper() {
    }

    @Override
    public List<IngredientDetail> mapFromEntity(List<IngredientDetailEntity> ingredientDetailEntity) {
        return Arrays.asList(MapperUtils.transform(ingredientDetailEntity, IngredientDetail[].class));
    }

    @Override
    public List<IngredientDetailEntity> mapToEntity(List<IngredientDetail> ingredientDetail) {
        return Arrays.asList(MapperUtils.transform(ingredientDetail, IngredientDetailEntity[].class));
    }

}
