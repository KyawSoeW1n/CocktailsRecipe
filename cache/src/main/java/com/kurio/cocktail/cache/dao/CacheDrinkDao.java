package com.kurio.cocktail.cache.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kurio.cocktail.cache.db.ConstantDrink;
import com.kurio.cocktail.cache.model.CacheDrink;

import java.util.List;

import io.reactivex.Single;

@Dao
public abstract class CacheDrinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract public void saveDrink(CacheDrink cacheDrink);

    @Query(ConstantDrink.QUERY_ALL_FAV_DRINK)
    abstract public Single<List<CacheDrink>> getCachedDrinkList();

    @Query(ConstantDrink.QUERY_DELETE_ALL_FAV_DRINK)
    public abstract void deleteAllDrink();

    @Query(ConstantDrink.QUERY_DELETE_DRINK + ":drinkId")
    public abstract void deleteDrink(String drinkId);
}

