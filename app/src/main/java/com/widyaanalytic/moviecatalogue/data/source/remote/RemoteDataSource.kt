package com.widyaanalytic.moviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        private const val TAG = "Movie Repository"
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource().apply { instance = this }
            }
    }

    fun getMovies(): LiveData<ApiResponse<List<ResultsMovie>>>{
        val resultMovie = MutableLiveData<ApiResponse<List<ResultsMovie>>>()

        val client = ApiConfig.getApiService().getPopularMovies(API_KEY)
        client.enqueue(object : Callback<ResponseMovie>{
            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                if(response.isSuccessful){
                    resultMovie.value = response.body()?.results?.let { ApiResponse.success(it) }!!
                }
            }

            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return resultMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<ResultsItem>>>{
        val resultTvShow = MutableLiveData<ApiResponse<List<ResultsItem>>>()

        val client = ApiConfig.getApiService().getPopularTV(API_KEY)

        client.enqueue(object : Callback<com.widyaanalytic.moviecatalogue.data.source.remote.response.Response>{
            override fun onResponse(call: Call<com.widyaanalytic.moviecatalogue.data.source.remote.response.Response>, response: Response<com.widyaanalytic.moviecatalogue.data.source.remote.response.Response>) {
                if (response.isSuccessful){
                    resultTvShow.value = response.body()?.results?.let { ApiResponse.success(it) }!!
                }
            }

            override fun onFailure(call: Call<com.widyaanalytic.moviecatalogue.data.source.remote.response.Response>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return resultTvShow
    }

    fun getDetailTv(id: String): LiveData<ApiResponse<ResponseDetailTv>>{
        val resultTv = MutableLiveData<ApiResponse<ResponseDetailTv>>()

        val client = ApiConfig.getApiService().getDetailTV(id, API_KEY)
        client.enqueue(object : Callback<ResponseDetailTv>{
            override fun onResponse(call: Call<ResponseDetailTv>, response: Response<ResponseDetailTv>) {
                if(response.isSuccessful){
                    resultTv.value = response.body()?.let { ApiResponse.success(it) }!!
                }
            }

            override fun onFailure(call: Call<ResponseDetailTv>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return resultTv
    }

    fun getDetailMovie(id: String): LiveData<ApiResponse<ResponseDetailMovie>>{
        val resultMovie = MutableLiveData<ApiResponse<ResponseDetailMovie>>()

        val client = ApiConfig.getApiService().getDetailMovie(id, API_KEY)

        client.enqueue(object : Callback<ResponseDetailMovie>{
            override fun onResponse(call: Call<ResponseDetailMovie>, response: Response<ResponseDetailMovie>) {
                if(response.isSuccessful){
                    resultMovie.value = response.body()?.let { ApiResponse.success(it) }!!
                }
            }

            override fun onFailure(call: Call<ResponseDetailMovie>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return resultMovie
    }

}