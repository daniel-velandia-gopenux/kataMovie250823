package com.xurxodev.moviesandroidkata.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import com.xurxodev.moviesandroidkata.databinding.ItemMoviesBinding;
import com.xurxodev.moviesandroidkata.model.Movie;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private ItemMoviesBinding binding;

    @Inject
    Picasso picasso;

    public List<Movie> movies = new ArrayList<>();

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public void clearMovies() {
        movies = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = ItemMoviesBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Movie movie = movies.get(position);
        holder.render(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemMoviesBinding binding;

        public ViewHolder(ItemMoviesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void render(Movie movie) {
            picasso.get()
                    .load(movie.getImage())
                    .into(binding.itemMoviePoster);

            binding.itemMovieTitle.setText(movie.getTitle());
        }
    }
}
