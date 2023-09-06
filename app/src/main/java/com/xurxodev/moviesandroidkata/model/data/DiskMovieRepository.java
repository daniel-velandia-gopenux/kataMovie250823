package com.xurxodev.moviesandroidkata.model.data;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.model.Movie;
import com.xurxodev.moviesandroidkata.view.fragment.MoviesFragment;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DiskMovieRepository implements MoviesFragment.MovieRepository {

    Context applicationContext;
    Gson gson;

    @Inject
    public DiskMovieRepository(Context applicationContext, Gson gson) {
        this.applicationContext = applicationContext;
        this.gson = gson;
    }

    public List<Movie> getMovies() {
        List<Movie> movies = convertJsonStringToList();
        simulateDelay();

        return movies;
    }

    private List<Movie> convertJsonStringToList() {
        String jsonString = getJsonString();
        Movie[] movies = gson.fromJson(jsonString, Movie[].class);

        return Arrays.asList(movies);
    }

    public String getJsonString() {
        try {
            return convertJsonToString();
        } catch (IOException e){
            Log.e("Error reading file", e.getMessage());
        }
        return "";
    }

    private String convertJsonToString() throws IOException {
        InputStream inputStream = applicationContext.getResources().openRawResource(R.raw.movies);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);

        return new String(b);
    }

    private void simulateDelay(){
        try {
            int timeOfDelay = 2000;
            Thread.sleep(timeOfDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
