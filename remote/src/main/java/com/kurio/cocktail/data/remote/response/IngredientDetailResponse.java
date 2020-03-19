package com.kurio.cocktail.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class IngredientDetailResponse {
    @SerializedName("strIngredient")
    private String strIngredient;
    @SerializedName("strAlcohol")
    private String strAlcohol;
    @SerializedName("strType")
    private String strType;
    @SerializedName("strDescription")
    private String strDescription;

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
