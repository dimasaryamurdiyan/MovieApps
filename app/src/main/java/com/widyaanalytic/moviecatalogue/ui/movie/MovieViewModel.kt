package com.widyaanalytic.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsMovie
import com.widyaanalytic.moviecatalogue.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel(){
    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = movieRepository.getMovies()
}
