package com.kurio.cocktail.cache.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kurio.cocktail.cache.dao.CacheDrinkDao;
import com.kurio.cocktail.cache.dao.CacheIngredientDao;
import com.kurio.cocktail.cache.model.CacheDrink;
import com.kurio.cocktail.cache.model.CacheIngredient;

import javax.inject.Inject;

@Database(entities = {CacheDrink.class, CacheIngredient.class}, version = 1, exportSchema = false)
public abstract class CocktailDatabase extends RoomDatabase {

    @Inject
    public CocktailDatabase() {

    }

    public abstract CacheDrinkDao cachedDrinkDao();

    public abstract CacheIngredientDao cachedIngredientDao();

    private static CocktailDatabase INSTANCE = null;

    public static synchronized CocktailDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CocktailDatabase.class, "cocktail.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
