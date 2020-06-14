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
    private String drinkName = "";

    @ColumnInfo(name = ConstantIngredient.INGREDIENT_URL)
    private String ingredientUrl = "";

    @ColumnInfo(name = ConstantIngredient.INGREDIENT_DESCRIPTION)
    private String ingredientDescription = "";

    @ColumnInfo(name = ConstantIngredient.IS_ALCOHOL)
    private String isAlcohol = "";

    public CacheIngredient(@NonNull String idIngredient, String drinkName, String ingredientUrl, String ingredientDescription, String isAlcohol) {
        this.idIngredient = idIngredient;
        this.drinkName = drinkName;
        this.ingredientUrl = ingredientUrl;
        this.ingredientDescription = ingredientDescription;
        this.isAlcohol = isAlcohol;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getIngredientUrl() {
        return ingredientUrl;
    }

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public String getIsAlcohol() {
        return isAlcohol;
    }

    public String getIdIngredient() {
        return idIngredient;
    }
}
