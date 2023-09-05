package com.xurxodev.moviesandroidkata.di.component;

import android.app.Application;
import com.xurxodev.moviesandroidkata.di.module.RepoModule;
import com.xurxodev.moviesandroidkata.view.fragment.MoviesFragment;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RepoModule.class})
public interface AppComponent {
    void inject(MoviesFragment moviesFragment);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application application);
    }
}
