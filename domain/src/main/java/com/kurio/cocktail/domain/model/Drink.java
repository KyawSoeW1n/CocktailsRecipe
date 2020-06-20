package com.kurio.cocktail.domain.model;

public class Drink {
    private String strDrink;
    private String strDrinkThumb;
    private String idDrink;
    private String strInstructions;

    public Drink(String strDrink, String strDrinkThumb, String drinkId, String strInstructions) {
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = drinkId;
        this.strInstructions = strInstructions;
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

    public String getStrInstructions() {
        return strInstructions;
    }

}
