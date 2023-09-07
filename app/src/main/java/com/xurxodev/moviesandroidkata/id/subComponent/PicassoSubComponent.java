package com.xurxodev.moviesandroidkata.id.subComponent;

import com.xurxodev.moviesandroidkata.view.fragment.MoviesFragment;
import com.xurxodev.moviesandroidkata.id.subComponent.module.PicassoModule;

import dagger.Subcomponent;

@Subcomponent(modules = {PicassoModule.class})
public interface PicassoSubComponent {

    void inject(MoviesFragment moviesFragment);

    @Subcomponent.Factory
    interface Factory {
        PicassoSubComponent create();
    }

}
