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

public class DrinkDetailResponseMapper implements ResponseMapper<ServerResponse, List<CocktailDetailEntity>> {

    @Inject
    public DrinkDetailResponseMapper() {

    }

    @Override
    public List<CocktailDetailEntity> mapFromResponse(ServerResponse response) {
        List<CocktailDetailEntity> cocktailDetailEntityList = new ArrayList<>();
        List<CocktailDetailResponse> cocktailDetail = new Gson().fromJson(new Gson().toJson(response.data), new TypeToken<List<CocktailDetailResponse>>() {
        }.getType());
        for (CocktailDetailResponse cocktailDetailResponse : cocktailDetail) {
            cocktailDetailEntityList.add(new CocktailDetailEntity(cocktailDetailResponse.getStrDrink(),
                    cocktailDetailResponse.getStrDrinkThumb(),
                    cocktailDetailResponse.getIdDrink(),
                    cocktailDetailResponse.getStrInstructions(),
                    cocktailDetailResponse.getStrIngredient1(),
                    cocktailDetailResponse.getStrIngredient2(),
                    cocktailDetailResponse.getStrIngredient3(),
                    cocktailDetailResponse.getStrIngredient4(),
                    cocktailDetailResponse.getStrIngredient5(),
                    cocktailDetailResponse.getStrIngredient6(),
                    cocktailDetailResponse.getStrIngredient7(),
                    cocktailDetailResponse.getStrIngredient8(),
                    cocktailDetailResponse.getStrIngredient9(),
                    cocktailDetailResponse.getStrIngredient10(),
                    cocktailDetailResponse.getStrIngredient11(),
                    cocktailDetailResponse.getStrIngredient12(),
                    cocktailDetailResponse.getStrIngredient13(),
                    cocktailDetailResponse.getStrIngredient14(),
                    cocktailDetailResponse.getStrIngredient15()));
        }
        return cocktailDetailEntityList;
    }
}
