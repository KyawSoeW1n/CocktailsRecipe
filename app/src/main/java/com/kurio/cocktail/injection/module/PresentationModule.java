package com.kurio.cocktail.injection.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kurio.cocktail.data.presentation.DrinkDetailViewModel;
import com.kurio.cocktail.data.presentation.CocktailViewModel;
import com.kurio.cocktail.data.presentation.IngredientDetailViewModel;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PresentationModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(CocktailViewModel.class)
    public abstract ViewModel bindCocktailListViewModel(CocktailViewModel cocktailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DrinkDetailViewModel.class)
    public abstract ViewModel bindCocktailDetailViewModel(DrinkDetailViewModel drinkDetailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(IngredientDetailViewModel.class)
    public abstract ViewModel bindIngredientDetailViewModel(IngredientDetailViewModel ingredientDetailViewModel);

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
}