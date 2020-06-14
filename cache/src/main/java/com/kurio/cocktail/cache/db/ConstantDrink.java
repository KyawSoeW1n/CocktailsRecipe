package com.kurio.cocktail.cache.db;

public class ConstantDrink {
    public static final String TABLE_NAME = "drink_table";
    public static final String DRINK_URL = "drink_url";
    public static final String DRINK_ID = "drink_id";
    public static final String DRINK_NAME = "drink_name";
    public static final String QUERY_ALL_FAV_DRINK = "SELECT * FROM " + TABLE_NAME;
    public static final String QUERY_DELETE_ALL_FAV_DRINK = "DELETE FROM " + TABLE_NAME;
    public static final String QUERY_DELETE_DRINK = "DELETE FROM " + TABLE_NAME + " WHERE " + DRINK_ID + " = ";
}
