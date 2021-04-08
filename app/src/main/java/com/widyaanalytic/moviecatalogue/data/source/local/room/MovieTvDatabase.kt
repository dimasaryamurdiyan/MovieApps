package com.widyaanalytic.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity

@Database(entities = [MovieEntity::class, TvEntity::class],
    version = 1, exportSchema = false)
abstract class MovieTvDatabase: RoomDatabase() {
    abstract fun movieTvDao(): MovieTvDao

    companion object{
        @Volatile
        private var INSTANCE: MovieTvDatabase? = null

        fun getInstance(context: Context): MovieTvDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieTvDatabase::class.java,
                    "MovieTv.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}