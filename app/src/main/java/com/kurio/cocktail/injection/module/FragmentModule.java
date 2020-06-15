package com.kurio.cocktail.injection.module;


import com.kurio.cocktail.fragment.FragmentAbout;
import com.kurio.cocktail.fragment.FragmentDashboard;
import com.kurio.cocktail.fragment.FragmentDrink;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    public abstract FragmentDashboard contributeFragmentDashboard();

    @ContributesAndroidInjector
    public abstract FragmentAbout contributeFragmentAbout();

    @ContributesAndroidInjector
    public abstract FragmentDrink contributeFragmentFavouriteDrinkAndIngredient();

}
