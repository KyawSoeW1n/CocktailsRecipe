package com.kurio.cocktail.cache.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kurio.cocktail.cache.db.ConstantIngredient;

@Entity(tableName = ConstantIngredient.TABLE_NAME)
public class CacheIngredient {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = ConstantIngredient.INGREDIENT_ID)
    private String idIngredient = "";

    @ColumnInfo(name = ConstantIngredient.INGREDIENT_NAME)
    private String strIngredient = "";

    @ColumnInfo(name = ConstantIngredient.INGREDIENT_URL)
    private String ingredientUrl = "";

    @ColumnInfo(name = ConstantIngredient.INGREDIENT_DESCRIPTION)
    private String strDescription = "";

    @ColumnInfo(name = ConstantIngredient.IS_ALCOHOL)
    private String strAlcohol = "";


    public CacheIngredient(@NonNull String idIngredient, String strIngredient, String ingredientUrl, String strDescription, String strAlcohol) {
        this.idIngredient = idIngredient;
        this.strIngredient = strIngredient;
        this.ingredientUrl = ingredientUrl;
        this.strDescription = strDescription;
        this.strAlcohol = strAlcohol;
    }

    @NonNull
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
