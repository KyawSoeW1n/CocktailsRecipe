package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.domain.model.IngredientDetail;

import javax.inject.Inject;

public class IngredientDetailMapper implements EntityMapper<IngredientDetailEntity, IngredientDetail> {

    @Inject
    public IngredientDetailMapper() {
    }

    @Override
    public IngredientDetail mapFromEntity(IngredientDetailEntity ingredientDetailEntity) {
        return new IngredientDetail(ingredientDetailEntity.getStrIngredient(),
                ingredientDetailEntity.getStrAlcohol(),
                ingredientDetailEntity.getStrType(),
                ingredientDetailEntity.getStrDescription());
    }

    @Override
    public IngredientDetailEntity mapToEntity(IngredientDetail ingredientDetail) {
        return new IngredientDetailEntity(ingredientDetail.getStrIngredient(),
                ingredientDetail.getStrAlcohol(),
                ingredientDetail.getStrType(),
                ingredientDetail.getStrDescription()
        );
    }

}
