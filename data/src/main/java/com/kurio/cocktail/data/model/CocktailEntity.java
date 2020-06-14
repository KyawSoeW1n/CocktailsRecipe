package com.kurio.cocktail.data.model;

public class CocktailEntity {
    private String strDrink;
    private String strDrinkThumb;
    private String idDrink;
    private String getStrInstructions;

    public CocktailEntity(String strDrink, String strDrinkThumb, String drinkId, String getStrInstructions) {
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = drinkId;
        this.getStrInstructions = getStrInstructions;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getDrinkId() {
        return idDrink;
    }

    public String getGetStrInstructions() {
        return getStrInstructions;
    }
}
