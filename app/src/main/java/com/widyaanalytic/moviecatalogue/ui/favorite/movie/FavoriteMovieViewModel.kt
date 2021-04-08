package com.widyaanalytic.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository

class FavoriteMovieViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getFavoriteMovies(): LiveData<List<MovieEntity>> = movieRepository.getFavoritedMovie()
}