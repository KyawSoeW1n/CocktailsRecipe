package com.kurio.cocktail.domain.model;

public class IngredientDetail {
    private String strIngredient;
    private String strAlcohol;
    private String strType;
    private String strDescription;

    public IngredientDetail(String strIngredient, String strAlcohol, String strType, String strDescription) {
        this.strIngredient = strIngredient;
        this.strAlcohol = strAlcohol;
        this.strType = strType;
        this.strDescription = strDescription;
    }

    public String getStrIngredient() {
        return strIngredient;
    }

    public String getStrAlcohol() {
        return strAlcohol;
    }

    public String getStrType() {
        return strType;
    }

    public String getStrDescription() {
        return strDescription;
    }
}
