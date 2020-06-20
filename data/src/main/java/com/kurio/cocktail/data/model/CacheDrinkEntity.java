package com.kurio.cocktail.data.model;

public class CacheDrinkEntity {
    private String drinkId, drinkName, drinkUrl;

    public CacheDrinkEntity(String drinkId, String drinkName, String drinkUrl) {
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
