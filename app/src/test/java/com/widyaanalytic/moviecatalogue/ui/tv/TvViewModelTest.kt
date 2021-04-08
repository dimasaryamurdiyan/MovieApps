package com.widyaanalytic.moviecatalogue.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsItem
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {
    companion object{
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"

    }
    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<ResultsItem>>

    @Before
    fun setUp(){
        viewModel = TvViewModel(movieRepository)
    }
    @Test
    fun getTvShows() {
        val tvShows = MutableLiveData<List<ResultsItem>>()
        val client = ApiConfig.getApiService().getPopularTV(API_KEY).execute()
        val response = client.body()?.results
        val responseLive = response as List<ResultsItem>
        tvShows.value = responseLive

        Mockito.`when`(movieRepository.getTvShows()).thenReturn(tvShows)
        val tvEntities =viewModel.getTvShows().value
        verify(movieRepository).getTvShows()

//        val a = responseLive.
        assertNotNull(tvEntities)
        assertEquals(20, response.size)

        //repeatly observe forever
        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(responseLive)
    }
}