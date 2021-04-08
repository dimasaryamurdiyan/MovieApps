package com.widyaanalytic.moviecatalogue.utils

import android.content.Context
import com.widyaanalytic.moviecatalogue.data.source.local.LocalDataSource
import com.widyaanalytic.moviecatalogue.data.source.local.room.MovieTvDatabase
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieRepository{

        val database = MovieTvDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieTvDao())
        val appExecutors = AppExecutors()
        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}