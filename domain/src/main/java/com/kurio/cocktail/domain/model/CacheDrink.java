package com.kurio.cocktail.domain.model;

public class CacheDrink {
    private String drinkId, drinkName, drinkUrl;

    public CacheDrink(String drinkId, String drinkName, String drinkUrl) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkUrl = drinkUrl;
    }

    public String getDrinkId() {
        return drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getDrinkUrl() {
        return drinkUrl;
    }
}
