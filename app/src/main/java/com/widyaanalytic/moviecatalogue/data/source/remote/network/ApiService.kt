package com.widyaanalytic.moviecatalogue.data.source.remote.network

import com.widyaanalytic.moviecatalogue.data.source.remote.response.Response
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailMovie
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailTv
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/popular")
    fun getPopularMovies(
        @Query("api_key") key: String
    ): Call<ResponseMovie>

    @GET("/3/tv/popular")
    fun getPopularTV(
        @Query("api_key") key: String
    ): Call<Response>

    @GET("/3/movie/{id}")
    fun getDetailMovie(
        @Path("id") id: String,
        @Query("api_key") key: String
    ): Call<ResponseDetailMovie>

    @GET("/3/tv/{id}")
    fun getDetailTV(
            @Path("id") id: String,
            @Query("api_key") key: String
    ): Call<ResponseDetailTv>
}