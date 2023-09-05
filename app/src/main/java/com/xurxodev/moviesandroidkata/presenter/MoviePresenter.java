package com.xurxodev.moviesandroidkata.presenter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.xurxodev.moviesandroidkata.model.Movie;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MoviePresenter {

    MovieRepository movieRepository;
    MoviesView view;

    @Inject
    public MoviePresenter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void AttachView(MoviesView view) {
        this.view = view;

        loadMovies();
    }

    public void onRefreshMovies() {
        loadMovies();
    }

    public void loadMovies() {
        view.loadingMovies();

        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,List<Movie>> moviesAsyncTask = new AsyncTask<Void, Void, List<Movie>>() {
            @Override
            protected List<Movie> doInBackground(Void... params) {
                return movieRepository.getMovies();
            }

            @Override
            protected void onPostExecute(List<Movie> movies) {
                view.loadedMovies(movies);
            }
        };

        moviesAsyncTask.execute();
    }

    public interface MoviesView {
        void loadingMovies();
        void loadedMovies(List<Movie> movies);
    }
}
