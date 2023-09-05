package com.xurxodev.moviesandroidkata.di.module;

import android.app.Application;
import com.xurxodev.moviesandroidkata.data.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.view.fragment.MovieRepository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class RepoModule {

    @Singleton
    @Provides
    MovieRepository provideRepoModule(Application application) {
        return new DiskMovieRepository(application);
    }
}
