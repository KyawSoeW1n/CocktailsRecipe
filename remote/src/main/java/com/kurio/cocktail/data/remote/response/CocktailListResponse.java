package com.kurio.cocktail.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class CocktailListResponse {
    @SerializedName("strDrink")
    private String strDrink;
    @SerializedName("strDrinkThumb")
    private String strDrinkThumb;
    @SerializedName("idDrink")
    private String idDrink;
    @SerializedName("strInstructions")
    private String strInstructions;

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }
}
