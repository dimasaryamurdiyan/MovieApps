package com.widyaanalytic.moviecatalogue.ui.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.vo.Resource

class FavoriteTvShowViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getFavoriteTvShows(): LiveData<List<TvEntity>> = movieRepository.getFavoritedTvShow()
}