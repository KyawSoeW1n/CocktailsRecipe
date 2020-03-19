package com.kurio.cocktail.domain.model;

public class Cocktail {
    private String strDrink;
    private String strDrinkThumb;
    private String drinkId;
    private String strInstructions;

    public Cocktail(String strDrink, String strDrinkThumb, String drinkId, String strInstructions) {
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.drinkId = drinkId;
        this.strInstructions = strInstructions;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getDrinkId() {
        return drinkId;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

}
