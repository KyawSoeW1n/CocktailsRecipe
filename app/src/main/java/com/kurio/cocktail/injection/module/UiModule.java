package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.UiThread;
import com.kurio.cocktail.activity.DrinkDetailActivity;
import com.kurio.cocktail.activity.HostActivity;
import com.kurio.cocktail.activity.IngredientDetailActivity;
import com.kurio.cocktail.domain.executor.PostExecutionThread;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UiModule {

    @Binds
    public abstract PostExecutionThread bindPostExecutionThread(UiThread uiThread);

    @ContributesAndroidInjector
    public abstract DrinkDetailActivity contributesCocktailDetailActivity();

    @ContributesAndroidInjector
    public abstract IngredientDetailActivity contributesIngredientDetailActivity();

    @ContributesAndroidInjector
    public abstract HostActivity contributesHostActivity();
}
