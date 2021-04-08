package com.widyaanalytic.moviecatalogue.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.response.*
import com.widyaanalytic.moviecatalogue.vo.Resource

class DetailMovieTvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    val id = MutableLiveData<String>()

    fun setSelectedData(id: String) {
        this.id.value = id
    }

    var movies: LiveData<Resource<MovieEntity>> = Transformations.switchMap(id) { movieId ->
        movieRepository.getMovieDetail(movieId)
    }

    var tv: LiveData<Resource<TvEntity>> = Transformations.switchMap(id) { tvId ->
        movieRepository.getTvDetail(tvId)
    }


    fun setFavoritedMovie(){
        val mMovies = movies.value
        Log.d("fav", mMovies.toString())
        if(mMovies!=null){
            val movieEntity = mMovies.data
            if(movieEntity!=null){
                val newState = !movieEntity.favorite
                movieRepository.setMovieFavorite(movieEntity, newState)
            }
        }
    }

    fun setFavoritedTvShow(){
        val mTvs = tv.value

        if(mTvs!=null){
            val tvEntity = mTvs.data
            val newState = !tvEntity?.favorite!!
            movieRepository.setTvShowFavorite(tvEntity, newState)
        }
    }
}