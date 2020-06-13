package com.kurio.cocktail.injection.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.kurio.cocktail.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getApplicationContext().getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
    }
}
