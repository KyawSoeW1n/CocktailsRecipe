package com.kurio.cocktail.callback;

import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;

public interface ClickIngredientItem {
    void clickIngredientItem(CocktailDetail cocktailDetail);
}
