package com.kurio.cocktail.injection;

import android.app.Application;

import com.kurio.cocktail.CocktailApplication;
import com.kurio.cocktail.injection.module.ApplicationModule;
import com.kurio.cocktail.injection.module.DataModule;
import com.kurio.cocktail.injection.module.FragmentModule;
import com.kurio.cocktail.injection.module.PresentationModule;
import com.kurio.cocktail.injection.module.RemoteBindsModule;
import com.kurio.cocktail.injection.module.RemoteModule;
import com.kurio.cocktail.injection.module.SharedPreferenceModule;
import com.kurio.cocktail.injection.module.UiModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, UiModule.class, PresentationModule.class, DataModule.class, RemoteModule.class, RemoteBindsModule.class, FragmentModule.class, SharedPreferenceModule.class})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(CocktailApplication app);
}
