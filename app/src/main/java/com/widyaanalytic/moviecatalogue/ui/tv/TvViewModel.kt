package com.widyaanalytic.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widyaanalytic.moviecatalogue.data.TVShowEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.Response
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsItem
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsMovie
import com.widyaanalytic.moviecatalogue.ui.movie.MovieViewModel
import com.widyaanalytic.moviecatalogue.utils.DataDummy
import com.widyaanalytic.moviecatalogue.vo.Resource
import retrofit2.Call
import retrofit2.Callback

class TvViewModel(private val movieRepository: MovieRepository)  : ViewModel() {
    fun getTvShows(): LiveData<Resource<List<TvEntity>>> = movieRepository.getTvShows()
}