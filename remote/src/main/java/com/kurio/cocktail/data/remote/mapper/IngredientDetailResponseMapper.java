package com.kurio.cocktail.data.remote.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.IngredientDetailEntity;
import com.kurio.cocktail.data.remote.response.CocktailDetailResponse;
import com.kurio.cocktail.data.remote.response.DrinkResponse;
import com.kurio.cocktail.data.remote.response.IngredientDetailResponse;
import com.kurio.cocktail.data.remote.response.IngredientResponse;

import java.util.List;

import javax.inject.Inject;

public class IngredientDetailResponseMapper implements ResponseMapper<IngredientResponse, IngredientDetailEntity> {

    @Inject
    public IngredientDetailResponseMapper() {

    }

    @Override
    public IngredientDetailEntity mapFromResponse(IngredientResponse response) {
        List<IngredientDetailResponse> ingredientDetailResponses = new Gson().fromJson(new Gson().toJson(response.data), new TypeToken<List<IngredientDetailResponse>>() {
        }.getType());

        for (IngredientDetailResponse ingredientDetailResponse : ingredientDetailResponses) {
            return new IngredientDetailEntity(ingredientDetailResponse.getStrIngredient(),
                    ingredientDetailResponse.getStrAlcohol(),
                    ingredientDetailResponse.getStrType(),
                    ingredientDetailResponse.getStrDescription());
        }
        return null;
    }
}
