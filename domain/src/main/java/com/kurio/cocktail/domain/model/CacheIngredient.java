package com.kurio.cocktail.domain.model;

public class CacheIngredient {
    private String idIngredient, strIngredient, ingredientUrl, strDescription, strAlcohol;

    public CacheIngredient(String idIngredient, String strIngredient, String ingredientUrl, String strDescription, String strAlcohol) {
        this.idIngredient = idIngredient;
        this.strIngredient = strIngredient;
        this.ingredientUrl = ingredientUrl;
        this.strDescription = strDescription;
        this.strAlcohol = strAlcohol;
    }

    public String getIdIngredient() {
        return idIngredient;
    }

    public String getStrIngredient() {
        return strIngredient;
    }

    public String getIngredientUrl() {
        return ingredientUrl;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public String getStrAlcohol() {
        return strAlcohol;
    }
}
