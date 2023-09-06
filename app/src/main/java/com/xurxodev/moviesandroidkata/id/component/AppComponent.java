package com.xurxodev.moviesandroidkata.id.component;

import android.app.Application;

import com.xurxodev.moviesandroidkata.id.module.AppModule;
import com.xurxodev.moviesandroidkata.id.module.NetModule;
import com.xurxodev.moviesandroidkata.view.fragment.MoviesFragment;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(MoviesFragment moviesFragment);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application application);
    }
}
