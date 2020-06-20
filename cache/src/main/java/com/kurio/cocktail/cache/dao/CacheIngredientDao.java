package com.kurio.cocktail.cache.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kurio.cocktail.cache.db.ConstantDrink;
import com.kurio.cocktail.cache.db.ConstantIngredient;
import com.kurio.cocktail.cache.model.CacheDrink;
import com.kurio.cocktail.cache.model.CacheIngredient;

import java.util.List;

import io.reactivex.Single;

@Dao
public abstract class CacheIngredientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract public void saveIngredient(CacheIngredient cacheDrink);

    @Query(ConstantIngredient.QUERY_ALL_FAV_INGREDIENT)
    abstract public Single<List<CacheIngredient>> getCachedIngredientList();

    @Query(ConstantIngredient.QUERY_DELETE_ALL_FAV_INGREDIENT)
    public abstract void deleteAllIngredient();

    @Query(ConstantIngredient.QUERY_DELETE_INGREDIENT + ":ingredientId")
    public abstract void deleteIngredient(String ingredientId);

    @Query(ConstantIngredient.QUERY_GET_INGREDIENT + ":ingredientId")
    public abstract Single<CacheIngredient> getIngredient(String ingredientId);
}