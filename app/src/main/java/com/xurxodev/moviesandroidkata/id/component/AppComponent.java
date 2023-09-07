package com.xurxodev.moviesandroidkata.id.component;

import android.app.Application;

import com.xurxodev.moviesandroidkata.id.SubComponents;
import com.xurxodev.moviesandroidkata.id.component.module.AppModule;
import com.xurxodev.moviesandroidkata.id.component.module.NetModule;
import com.xurxodev.moviesandroidkata.id.subComponent.PicassoSubComponent;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, SubComponents.class})
public interface AppComponent {
    // void inject(MoviesFragment moviesFragment);

    PicassoSubComponent.Factory getPicassoSubComponent();

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application application);
    }
}
