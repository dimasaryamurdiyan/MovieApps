package com.widyaanalytic.moviecatalogue.data.source.local.room

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.room.*
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity

@Dao
interface MovieTvDao {
    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tventities")
    fun getTvs(): LiveData<List<TvEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvs(tvShows: List<TvEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvEntity: TvEntity)

    @Query("SELECT * FROM movieentities WHERE id = :movieId")
    fun getDetailMovie(movieId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tventities WHERE id = :tvId")
    fun getDetailTv(tvId: String): LiveData<TvEntity>

    @Query("UPDATE movieentities SET genre = :genre WHERE id = :movieId")
    fun updateMovieById(genre: String, movieId:String)

    @Query("UPDATE tventities SET genre = :genre, episodes = :episodes WHERE id = :tvId")
    fun updateTvById(genre: String,episodes: String ,tvId:String)

    @Query("SELECT * from movieentities where favorited = 1")
    fun getFavoritedMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * from tventities where favorited = 1")
    fun getFavoritedTvShow(): LiveData<List<TvEntity>>

}