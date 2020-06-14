package com.kurio.cocktail.cache.db;

public class ConstantIngredient {

    public static final String TABLE_NAME = "ingredient_table";
    public static final String INGREDIENT_NAME = "ingredient_name";
    public static final String INGREDIENT_URL = "ingredient_url";
    public static final String INGREDIENT_DESCRIPTION = "ingredient_description";
    public static final String INGREDIENT_ID = "ingredient_id";
    public static final String IS_ALCOHOL = "isAlcohol";
    public static final String QUERY_ALL_FAV_INGREDIENT = "SELECT * FROM " + TABLE_NAME;
    public static final String QUERY_DELETE_ALL_FAV_INGREDIENT = "DELETE FROM " + TABLE_NAME;
    public static final String QUERY_DELETE_INGREDIENT = "DELETE FROM " + TABLE_NAME + " WHERE " + INGREDIENT_ID + " = ";
}
