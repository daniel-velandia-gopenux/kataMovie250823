package com.xurxodev.moviesandroidkata;

import android.app.Application;
import com.xurxodev.moviesandroidkata.id.component.AppComponent;
import com.xurxodev.moviesandroidkata.id.component.DaggerAppComponent;

public class App extends Application {

    public AppComponent appComponent = DaggerAppComponent.factory().create(this);
}
