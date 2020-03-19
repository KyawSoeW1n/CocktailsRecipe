package com.kurio.cocktail.data.mapper;

import com.kurio.cocktail.data.model.CocktailDetailEntity;
import com.kurio.cocktail.data.model.CocktailEntity;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CocktailDetailMapper implements EntityMapper<CocktailDetailEntity, CocktailDetail> {

    @Inject
    public CocktailDetailMapper() {
    }

    @Override
    public CocktailDetail mapFromEntity(CocktailDetailEntity cocktailDetailEntity) {
        return new CocktailDetail(cocktailDetailEntity.getStrDrink(),
                cocktailDetailEntity.getStrDrinkThumb(),
                cocktailDetailEntity.getDrinkId(),
                cocktailDetailEntity.getGetStrInstructions(),
                cocktailDetailEntity.getStrIngredient1(),
                cocktailDetailEntity.getStrIngredient2(),
                cocktailDetailEntity.getStrIngredient3(),
                cocktailDetailEntity.getStrIngredient4(),
                cocktailDetailEntity.getStrIngredient5(),
                cocktailDetailEntity.getStrIngredient6(),
                cocktailDetailEntity.getStrIngredient7(),
                cocktailDetailEntity.getStrIngredient8(),
                cocktailDetailEntity.getStrIngredient9(),
                cocktailDetailEntity.getStrIngredient10(),
                cocktailDetailEntity.getStrIngredient11(),
                cocktailDetailEntity.getStrIngredient12(),
                cocktailDetailEntity.getStrIngredient13(),
                cocktailDetailEntity.getStrIngredient14(),
                cocktailDetailEntity.getStrIngredient15());
    }

    @Override
    public CocktailDetailEntity mapToEntity(CocktailDetail cocktailDetail) {
        return new CocktailDetailEntity(cocktailDetail.getStrDrink(),
                cocktailDetail.getStrDrinkThumb(),
                cocktailDetail.getDrinkId(),
                cocktailDetail.getStrInstructions(),
                cocktailDetail.getStrIngredient1(),
                cocktailDetail.getStrIngredient2(),
                cocktailDetail.getStrIngredient3(),
                cocktailDetail.getStrIngredient4(),
                cocktailDetail.getStrIngredient5(),
                cocktailDetail.getStrIngredient6(),
                cocktailDetail.getStrIngredient7(),
                cocktailDetail.getStrIngredient8(),
                cocktailDetail.getStrIngredient9(),
                cocktailDetail.getStrIngredient10(),
                cocktailDetail.getStrIngredient11(),
                cocktailDetail.getStrIngredient12(),
                cocktailDetail.getStrIngredient13(),
                cocktailDetail.getStrIngredient14(),
                cocktailDetail.getStrIngredient15());
    }

}
