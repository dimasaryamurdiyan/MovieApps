package com.widyaanalytic.moviecatalogue.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.*
import com.widyaanalytic.moviecatalogue.ui.detail.DetailMovieTvViewModelTest
import com.widyaanalytic.moviecatalogue.ui.movie.MovieViewModelTest
import com.widyaanalytic.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {
    companion object{
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"
        private const val ID = "791373"
        private const val ID_TV = "60735"
    }
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private val movieRepository = FakeMovieRepository()


    @Test
    fun getMovies() {
        val movies = MutableLiveData<List<ResultsMovie>>()
        val client = ApiConfig.getApiService().getPopularMovies(API_KEY).execute()
        val response = client.body()?.results
        val responseLive = response as List<ResultsMovie>
        movies.value = responseLive

        `when`(movieRepository.getMovies()).thenReturn(movies)
        val movieEntities = movieRepository.getMovies().value
        Mockito.verify(movieRepository).getMovies()
        assertNotNull(movieEntities)
    }

    @Test
    fun getTvShows() {
        val tv = MutableLiveData<List<ResultsItem>>()
        val client = ApiConfig.getApiService().getPopularTV(API_KEY).execute()
        val response = client.body()?.results
        val responseLive = response as List<ResultsItem>
        tv.value = responseLive

        `when`(movieRepository.getTvShows()).thenReturn(tv)
        val tvEntities = movieRepository.getTvShows().value
        Mockito.verify(movieRepository).getTvShows()
        assertNotNull(tvEntities)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<ResponseDetailMovie>()
        val client = ApiConfig.getApiService().getDetailMovie(ID, API_KEY).execute()
        val response = client.body()
        val responseLive = response as ResponseDetailMovie
        movie.value = responseLive

        Mockito.`when`(movieRepository.getMovieDetail(ID)).thenReturn(movie)
        val movieEntity =movieRepository.getMovieDetail(ID).value
        verify(movieRepository).getMovieDetail(ID)

        assertNotNull(movieEntity)
    }

    @Test
    fun getTvDetail() {
        val tv = MutableLiveData<ResponseDetailTv>()
        val client = ApiConfig.getApiService().getDetailTV(ID_TV, API_KEY).execute()
        val response = client.body()
        val responseLive = response as ResponseDetailTv
        tv.value = responseLive

        Mockito.`when`(movieRepository.getTvDetail(ID_TV)).thenReturn(tv)
        val movieEntity =movieRepository.getTvDetail(ID_TV).value
        verify(movieRepository).getTvDetail(ID_TV)

        assertNotNull(movieEntity)
    }
}