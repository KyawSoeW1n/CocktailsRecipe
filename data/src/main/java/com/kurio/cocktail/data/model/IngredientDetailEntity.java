package com.kurio.cocktail.data.model;

public class IngredientDetailEntity {
    private String strIngredient;
    private String strAlcohol;
    private String strType;
    private String strDescription;
    private String idIngredient;

    public IngredientDetailEntity(String strIngredient,
                                  String strAlcohol,
                                  String strType,
                                  String strDescription,
                                  String idIngredient) {
        this.strIngredient = strIngredient;
        this.strAlcohol = strAlcohol;
        this.strType = strType;
        this.strDescription = strDescription;
        this.idIngredient = idIngredient;
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

    public String getIdIngredient() {
        return idIngredient;
    }
}
