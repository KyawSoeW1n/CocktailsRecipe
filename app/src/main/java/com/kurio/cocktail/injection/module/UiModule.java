package com.kurio.cocktail.injection.module;

import com.kurio.cocktail.UiThread;
import com.kurio.cocktail.domain.executor.PostExecutionThread;
import com.kurio.cocktail.activity.CocktailDetailActivity;
import com.kurio.cocktail.activity.IngredientDetailActivity;
import com.kurio.cocktail.activity.MainActivity;
import com.kurio.cocktail.domain.executor.PostExecutionThread;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UiModule {

    @Binds
    public abstract PostExecutionThread bindPostExecutionThread(UiThread uiThread);

    @ContributesAndroidInjector
    public abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    public abstract CocktailDetailActivity contributesCocktailDetailActivity();

    @ContributesAndroidInjector
    public abstract IngredientDetailActivity contributesIngredientDetailActivity();
}
