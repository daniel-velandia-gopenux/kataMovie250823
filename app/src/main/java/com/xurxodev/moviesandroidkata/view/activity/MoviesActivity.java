package com.xurxodev.moviesandroidkata.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.xurxodev.moviesandroidkata.databinding.ActivityMoviesBinding;
import com.xurxodev.moviesandroidkata.view.fragment.MoviesFragment;

public class MoviesActivity extends AppCompatActivity {

    private ActivityMoviesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMoviesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeToolBar();

        if (savedInstanceState == null) {
            showMovieListFragment();
        }
    }

    private void showMovieListFragment() {
        MoviesFragment fragment = new MoviesFragment();

        getSupportFragmentManager().beginTransaction()
                .add(binding.moviesListContainer.getId(), fragment)
                .commit();
    }

    private void initializeToolBar() {
        setSupportActionBar(binding.toolbar);
    }
}
