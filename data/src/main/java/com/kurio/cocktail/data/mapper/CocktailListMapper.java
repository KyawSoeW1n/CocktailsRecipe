package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.domain.model.Cocktail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CocktailListMapper implements EntityMapper<List<CocktailEntity>, List<Cocktail>> {

    @Inject
    public CocktailListMapper() {
    }

    @Override
    public List<Cocktail> mapFromEntity(List<CocktailEntity> entity) {
        List<Cocktail> drinksList = new ArrayList<>();
        for (CocktailEntity cocktailEntity : entity) {
            drinksList.add(new Cocktail(cocktailEntity.getStrDrink(),
                    cocktailEntity.getStrDrinkThumb(),
                    cocktailEntity.getDrinkId(),
                    cocktailEntity.getGetStrInstructions()));
        }
        return drinksList;
    }

    @Override
    public List<CocktailEntity> mapToEntity(List<Cocktail> cocktails) {
        List<CocktailEntity> cocktailEntityList = new ArrayList<>();
        for (Cocktail cocktail : cocktails) {
            cocktailEntityList.add(new CocktailEntity(
                    cocktail.getStrDrink(),
                    cocktail.getStrDrinkThumb(),
                    cocktail.getDrinkId(),
                    cocktail.getStrInstructions()));
        }
        return cocktailEntityList;
    }

}
