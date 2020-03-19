package com.kurio.cocktail.data.remote.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.remote.response.CocktailListResponse;
import com.kurio.cocktail.data.remote.response.CocktailDetailResponse;
import com.kurio.cocktail.data.remote.response.ServerResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CocktailDetailResponseMapper implements ResponseMapper<ServerResponse, CocktailDetailEntity> {

    @Inject
    public CocktailDetailResponseMapper() {

    }

    @Override
    public CocktailDetailEntity mapFromResponse(ServerResponse response) {
        List<CocktailDetailResponse> cocktailDetailResponse = new Gson().fromJson(new Gson().toJson(response.data), new TypeToken<List<CocktailDetailResponse>>() {
        }.getType());

        for (CocktailDetailResponse detailResponse : cocktailDetailResponse) {
            return new CocktailDetailEntity(detailResponse.getStrDrink(),
                    detailResponse.getStrDrinkThumb(),
                    detailResponse.getIdDrink(),
                    detailResponse.getStrInstructions(),
                    detailResponse.getStrIngredient1(),
                    detailResponse.getStrIngredient2(),
                    detailResponse.getStrIngredient3(),
                    detailResponse.getStrIngredient4(),
                    detailResponse.getStrIngredient5(),
                    detailResponse.getStrIngredient6(),
                    detailResponse.getStrIngredient7(),
                    detailResponse.getStrIngredient8(),
                    detailResponse.getStrIngredient9(),
                    detailResponse.getStrIngredient10(),
                    detailResponse.getStrIngredient11(),
                    detailResponse.getStrIngredient12(),
                    detailResponse.getStrIngredient13(),
                    detailResponse.getStrIngredient14(),
                    detailResponse.getStrIngredient15());
        }
        return null;
    }
}
