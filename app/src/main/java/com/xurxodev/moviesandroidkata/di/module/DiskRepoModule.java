package com.xurxodev.moviesandroidkata.di.module;

import android.app.Application;

import com.xurxodev.moviesandroidkata.data.DiskMovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DiskRepoModule {

    @Singleton
    @Provides
    DiskMovieRepository provideDiskRepoModule(Application application) {
        return new DiskMovieRepository(application);
    }
}
