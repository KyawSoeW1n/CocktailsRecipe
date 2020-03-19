package com.kurio.cocktail.cache.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import javax.inject.Inject;

public abstract class CurrencyExchangeDatabase extends RoomDatabase {

    @Inject
    public CurrencyExchangeDatabase() {

    }

    private static CurrencyExchangeDatabase INSTANCE = null;

    public static synchronized CurrencyExchangeDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CurrencyExchangeDatabase.class, "currencyexchange.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
