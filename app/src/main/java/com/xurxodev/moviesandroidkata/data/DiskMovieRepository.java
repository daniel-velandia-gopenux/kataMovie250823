package com.xurxodev.moviesandroidkata.data;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.model.Movie;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DiskMovieRepository {

    Context applicationContext;

    @Inject
    public DiskMovieRepository(Application applicationContext){
        this.applicationContext = applicationContext;
    }

    public List<Movie> getMovies() {
        List<Movie> movies = convertJsonStringToList();
        simulateDelay();

        return movies;
    }

    private List<Movie> convertJsonStringToList() {
        String jsonString = getJsonString();
        Gson gson = new Gson();
        Movie[] movies = gson.fromJson(jsonString, Movie[].class);

        return Arrays.asList(movies);
    }

    @SuppressLint("LongLogTag")
    public String getJsonString() {
        try {
            return convertJsonToString();
        } catch (IOException e){
            Log.e("An error occurred while reading the json file", e.getMessage());
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
