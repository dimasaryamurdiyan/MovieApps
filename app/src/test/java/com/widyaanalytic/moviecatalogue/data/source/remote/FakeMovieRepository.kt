package com.widyaanalytic.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback

class FakeMovieRepository : MovieDataSource{
    companion object{
        private const val TAG = "Movie Repository"
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"

    }

    override fun getMovies(): LiveData<List<ResultsMovie>> {
        val movieResults = MutableLiveData<List<ResultsMovie>>()
        val client = ApiConfig.getApiService().getPopularMovies(API_KEY)
        client.enqueue(object : Callback<ResponseMovie> {
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

            override fun onResponse(call: Call<ResponseMovie>, response: retrofit2.Response<ResponseMovie>) {

                if(response.isSuccessful){
                    val movieList = ArrayList<ResultsMovie>()
                    for (response in response.body()?.results!!){
                        val movie = ResultsMovie(
                                response.overview,
                                response.originalLanguage,
                                response.originalTitle,
                                response.video,
                                response.title,
                                response.genreIds,
                                response.posterPath,
                                response.backdropPath,
                                response.releaseDate,
                                response.popularity,
                                response.voteAverage,
                                response.id,
                                response.adult,
                                response.voteCount
                        )
                        movieList.add(movie)
                    }
                    movieResults.postValue(movieList)
                }else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
        })
        return movieResults
    }

    override fun getTvShows(): LiveData<List<ResultsItem>> {
        val tvResults = MutableLiveData<List<ResultsItem>>()
        val client = ApiConfig.getApiService().getPopularTV(API_KEY)
        client.enqueue(object: Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if(response.isSuccessful){
                    val tvList = ArrayList<ResultsItem>()
                    for (response in response.body()?.results!!){
                        val tv = ResultsItem(
                                response.firstAirDate,
                                response.overview,
                                response.originalLanguage,
                                response.genreIds,
                                response.posterPath,
                                response.originCountry,
                                response.backdropPath,
                                response.originalName,
                                response.popularity,
                                response.voteAverage,
                                response.name,
                                response.id,
                                response.voteCount
                        )
                        tvList.add(tv)
                    }
                    tvResults.postValue(tvList)
                }else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
        return tvResults
    }

    override fun getMovieDetail(id: String): LiveData<ResponseDetailMovie> {
        val movieDetail = MutableLiveData<ResponseDetailMovie>()

        val client = ApiConfig.getApiService().getDetailMovie(id, API_KEY)
        client.enqueue(object : Callback<ResponseDetailMovie> {
            override fun onResponse(call: Call<ResponseDetailMovie>, response: retrofit2.Response<ResponseDetailMovie>) {
                if(response.isSuccessful){
                    val responseDetail = response.body()
                    movieDetail.postValue(responseDetail)
                }else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseDetailMovie>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return movieDetail
    }

    override fun getTvDetail(id: String): LiveData<ResponseDetailTv> {
        val tvDetail = MutableLiveData<ResponseDetailTv>()

        val client = ApiConfig.getApiService().getDetailTV(id, API_KEY)
        client.enqueue(object : Callback<ResponseDetailTv> {
            override fun onResponse(call: Call<ResponseDetailTv>, response: retrofit2.Response<ResponseDetailTv>) {
                if(response.isSuccessful){
                    val responseDetail = response.body()
                    tvDetail.postValue(responseDetail)
                }else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseDetailTv>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return tvDetail
    }

}