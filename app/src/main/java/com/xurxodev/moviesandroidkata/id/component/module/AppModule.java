package com.xurxodev.moviesandroidkata.id.component.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.xurxodev.moviesandroidkata.model.data.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.view.fragment.MoviesFragment;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    MoviesFragment.MovieRepository provideRepo(Application application, Gson gson) {
        return new DiskMovieRepository(application, gson);
    }

}
