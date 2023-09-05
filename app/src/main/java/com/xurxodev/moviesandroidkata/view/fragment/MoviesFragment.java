package com.xurxodev.moviesandroidkata.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xurxodev.moviesandroidkata.App;
import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.databinding.FragmentMoviesBinding;
import com.xurxodev.moviesandroidkata.presenter.MoviePresenter;
import com.xurxodev.moviesandroidkata.model.Movie;
import com.xurxodev.moviesandroidkata.view.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MoviesFragment extends Fragment implements MoviePresenter.MoviesView {

    private FragmentMoviesBinding binding;
    private MoviesAdapter adapter;
    @Inject
    MoviePresenter moviePresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((App) getActivity().getApplication()).appComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMoviesBinding.inflate(inflater);

        initializeRefreshButton();
        initializeAdapter();
        initializeRecyclerView();

        initializePresenter();

        return binding.getRoot();
    }

    private void initializePresenter() {
        moviePresenter.AttachView(this);
    }

    private void initializeRefreshButton(){
        binding.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moviePresenter.onRefreshMovies();
            }
        });
    }

    private void initializeAdapter() {
        adapter = new MoviesAdapter();
    }

    private void initializeRecyclerView() {
        binding.recyclerviewMovies.setAdapter(adapter);
    }

    @Override
    public void loadingMovies(){
        adapter.clearMovies();
        binding.moviesTitleTextView.setText(R.string.loading_movies_text);
    }

    @Override
    public void loadedMovies(List<Movie> movies){
        adapter.setMovies(movies);
        refreshTitleWithMoviesCount(movies);
    }

    private void refreshTitleWithMoviesCount(List<Movie> movies) {
        String countText = getString(R.string.movies_count_text);

        binding.moviesTitleTextView.setText(String.format(countText, movies.size()));
    }
}
