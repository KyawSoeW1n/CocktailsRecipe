package com.kurio.cocktail.data.remote.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.data.remote.response.CocktailListResponse;
import com.kurio.cocktail.data.remote.response.ServerResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CocktailListResponseMapper implements ResponseMapper<ServerResponse, List<CocktailEntity>> {

    @Inject
    public CocktailListResponseMapper() {

    }

    @Override
    public List<CocktailEntity> mapFromResponse(ServerResponse response) {
        List<CocktailEntity> actionHistoryList = new ArrayList<>();
        List<CocktailListResponse> sectionlist = new Gson().fromJson(new Gson().toJson(response.data), new TypeToken<List<CocktailListResponse>>() {
        }.getType());
        for (CocktailListResponse alcoholicDrink : sectionlist) {
            actionHistoryList.add(new CocktailEntity(alcoholicDrink.getStrDrink(),
                    alcoholicDrink.getStrDrinkThumb(),
                    alcoholicDrink.getIdDrink(),
                    alcoholicDrink.getStrInstructions()));
        }
        return actionHistoryList;
    }
}
