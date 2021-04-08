package com.widyaanalytic.moviecatalogue.data.source.local

import android.graphics.Movie
import androidx.lifecycle.LiveData
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.local.room.MovieTvDao

class LocalDataSource private constructor(private val mMovieTvDao: MovieTvDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieTvDao: MovieTvDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieTvDao).apply {
                INSTANCE = this
            }

    }

    fun getMovies(): LiveData<List<MovieEntity>> = mMovieTvDao.getMovies()
    fun getTvShows(): LiveData<List<TvEntity>> = mMovieTvDao.getTvs()

    fun insertMovie(movies: List<MovieEntity>)= mMovieTvDao.insertMovies(movies)
    fun insertTvShows(tvShows: List<TvEntity>)= mMovieTvDao.insertTvs(tvShows)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean){
        movie.favorite = newState
        mMovieTvDao.updateMovie(movie)
    }


    fun setFavoriteTvShow(tvShow: TvEntity, newState: Boolean){
        tvShow.favorite = newState
        mMovieTvDao.updateTvShow(tvShow)
    }

    fun getDetailTv(tvId: String): LiveData<TvEntity> =
        mMovieTvDao.getDetailTv(tvId)

    fun getDetailMovie(movieId: String): LiveData<MovieEntity> =
        mMovieTvDao.getDetailMovie(movieId)

    fun updateMovieById(movieId: String, genre: String){
        mMovieTvDao.updateMovieById(genre, movieId)
    }

    fun updateTvById(tvId: String, genre: String, episodes: String){
        mMovieTvDao.updateTvById(genre, episodes, tvId)
    }

    fun getFavoritedMovie(): LiveData<List<MovieEntity>> =
        mMovieTvDao.getFavoritedMovie()

    fun getFavoritedTvShow(): LiveData<List<TvEntity>> =
        mMovieTvDao.getFavoritedTvShow()
}