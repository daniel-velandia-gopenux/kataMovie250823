package com.xurxodev.moviesandroidkata;

import android.app.Application;

import com.xurxodev.moviesandroidkata.di.component.AppComponent;
import com.xurxodev.moviesandroidkata.di.component.DaggerAppComponent;

public class App extends Application {

    public AppComponent appComponent = DaggerAppComponent.factory().create(this);
}
