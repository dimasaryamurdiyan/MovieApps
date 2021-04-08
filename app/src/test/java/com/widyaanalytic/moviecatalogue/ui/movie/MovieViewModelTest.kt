package com.widyaanalytic.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsMovie
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    companion object{
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"
    }
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    
    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<ResultsMovie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }
    @Test
    fun getMovie() {
        val movies = MutableLiveData<List<ResultsMovie>>()
        val client = ApiConfig.getApiService().getPopularMovies(API_KEY).execute()
        val response = client.body()?.results
        val responseLive = response as List<ResultsMovie>
        movies.value = responseLive

        `when`(movieRepository.getMovies()).thenReturn(movies)
        val movieEntities =viewModel.getMovies().value
        verify(movieRepository).getMovies()

        assertNotNull(movieEntities)
        assertEquals(20, response.size)

        //repeatly observe forever
        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(responseLive)
    }
}