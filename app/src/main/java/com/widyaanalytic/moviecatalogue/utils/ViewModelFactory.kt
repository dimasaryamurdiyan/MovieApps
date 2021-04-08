package com.widyaanalytic.moviecatalogue.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.ui.detail.DetailMovieTvViewModel
import com.widyaanalytic.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel
import com.widyaanalytic.moviecatalogue.ui.favorite.tv.FavoriteTvShowViewModel
import com.widyaanalytic.moviecatalogue.ui.movie.MovieViewModel
import com.widyaanalytic.moviecatalogue.ui.tv.TvViewModel

class ViewModelFactory private constructor(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MovieViewModel::class.java)->{
                return MovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieTvViewModel::class.java)->{
                return DetailMovieTvViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java)->{
                return TvViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java)->{
                return FavoriteMovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java)->{
                return FavoriteTvShowViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}