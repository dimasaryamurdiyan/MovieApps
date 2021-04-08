package com.widyaanalytic.moviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailMovie
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailTv
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsItem
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsMovie
import com.widyaanalytic.moviecatalogue.vo.Resource

interface MovieDataSource {
    fun getMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getTvShows():LiveData<Resource<List<TvEntity>>>

    fun getMovieDetail(id: String): LiveData<Resource<MovieEntity>>

    fun getTvDetail(id: String): LiveData<Resource<TvEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvShowFavorite(tvShow: TvEntity, state: Boolean)

    fun getFavoritedMovie(): LiveData<List<MovieEntity>>

    fun getFavoritedTvShow(): LiveData<List<TvEntity>>
}