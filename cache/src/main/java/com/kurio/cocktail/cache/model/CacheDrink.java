package com.kurio.cocktail.cache.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kurio.cocktail.cache.db.ConstantDrink;

@Entity(tableName = ConstantDrink.TABLE_NAME)
public class CacheDrink {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = ConstantDrink.DRINK_ID)
    public String drinkId = "";
    @NonNull
    @ColumnInfo(name = ConstantDrink.DRINK_URL)
    public String drinkUrl = "";
    @NonNull
    @ColumnInfo(name = ConstantDrink.DRINK_NAME)
    public String drinkName = "";

}
