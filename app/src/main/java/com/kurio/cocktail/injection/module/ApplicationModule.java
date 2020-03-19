package com.kurio.cocktail.injection.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {

    @Binds
    public abstract Context bindContext(Application application);

}
