package com.xurxodev.moviesandroidkata.id.component.module;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class NetModule {

    @Singleton
    @Provides
    public HttpLoggingInterceptor ProvideHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor =  new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Singleton
    @Provides
    public File ProvideFile(Context context){
        File file = new File(context.getCacheDir(),"okhttp_cache");
        file.mkdirs();
        return file;
    }

    @Provides
    public Cache ProvideCache(File file){
        return new Cache(file, 10*104*1024);
    }

    @Singleton
    @Provides
    public OkHttpClient ProvideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }
}
