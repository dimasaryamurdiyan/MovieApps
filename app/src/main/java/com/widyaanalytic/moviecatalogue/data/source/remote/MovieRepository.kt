package com.widyaanalytic.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.widyaanalytic.moviecatalogue.data.NetworkBoundResource
import com.widyaanalytic.moviecatalogue.data.source.local.LocalDataSource
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.*
import com.widyaanalytic.moviecatalogue.utils.AppExecutors
import com.widyaanalytic.moviecatalogue.vo.Resource
import retrofit2.Call
import retrofit2.Callback

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): MovieDataSource {
    companion object{
        private const val TAG = "Movie Repository"
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"

        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieRepository =
                instance ?: synchronized(this) {
                    instance ?: MovieRepository(remoteData, localData, appExecutors)
                }
    }

    override fun getMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<ResultsMovie>>(appExecutors){
            override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsMovie>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<ResultsMovie>) {
                val movieList = ArrayList<MovieEntity>()

                for(response in data){
                    val movie = MovieEntity(
                        response.id,
                        response.overview,
                        response.originalTitle,
                        response.posterPath,
                        response.voteAverage,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }

        }.asLiveData()
    }

    override fun getTvShows(): LiveData<Resource<List<TvEntity>>> {
        return object : NetworkBoundResource<List<TvEntity>, List<ResultsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<List<TvEntity>> =
                localDataSource.getTvShows()

            override fun shouldFetch(data: List<TvEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<ResultsItem>) {
                val tvList = ArrayList<TvEntity>()

                for (response in data){
                    val tv = TvEntity(
                        response.id,
                        response.overview,
                        response.posterPath,
                        response.originalName,
                        response.voteAverage,
                        false
                    )

                    tvList.add(tv)
                }
                localDataSource.insertTvShows(tvList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(id: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, ResponseDetailMovie>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getDetailMovie(id)
            }


            override fun shouldFetch(data: MovieEntity?): Boolean =
                data?.genre!!.isEmpty()

            override fun createCall(): LiveData<ApiResponse<ResponseDetailMovie>> =
                remoteDataSource.getDetailMovie(id)

            override fun saveCallResult(data: ResponseDetailMovie) {
                val genreList = data.genres.map {
                    it.name
                }
                localDataSource.updateMovieById(id, genreList.toString())
            }

        }.asLiveData()
    }

    override fun getTvDetail(id: String): LiveData<Resource<TvEntity>> {
        return object : NetworkBoundResource<TvEntity, ResponseDetailTv>(appExecutors){
            override fun loadFromDB(): LiveData<TvEntity> = localDataSource.getDetailTv(id)

            override fun shouldFetch(data: TvEntity?): Boolean =
                data?.genre!!.isEmpty() || data.episodes.isEmpty()

            override fun createCall(): LiveData<ApiResponse<ResponseDetailTv>> =
                remoteDataSource.getDetailTv(id)

            override fun saveCallResult(data: ResponseDetailTv) {
                val genreList = data.genres.map {
                    it.name
                }
                val episode = data.numberOfEpisodes
                localDataSource.updateTvById(id, genreList.toString(), episode.toString())
            }
        }.asLiveData()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }

    override fun setTvShowFavorite(tvShow: TvEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }

    override fun getFavoritedMovie(): LiveData<List<MovieEntity>> =
        localDataSource.getFavoritedMovie()

    override fun getFavoritedTvShow(): LiveData<List<TvEntity>> =
        localDataSource.getFavoritedTvShow()

}