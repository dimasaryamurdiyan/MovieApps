package com.widyaanalytic.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.widyaanalytic.moviecatalogue.data.source.remote.MovieRepository
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailMovie
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailTv
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieTvViewModelTest {
    companion object{
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"
        private const val ID = "791373"
        private const val ID_TV = "88396"
    }

    private lateinit var viewModel: DetailMovieTvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerTv: Observer<ResponseDetailTv>

    @Mock
    private lateinit var observerMovie: Observer<ResponseDetailMovie>

    @Before
    fun setUp(){
        viewModel = DetailMovieTvViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<ResponseDetailMovie>()
        val client = ApiConfig.getApiService().getDetailMovie(ID, API_KEY).execute()
        val response = client.body()
        val responseLive = response as ResponseDetailMovie
        movie.value = responseLive

        Mockito.`when`(movieRepository.getMovieDetail(ID)).thenReturn(movie)
        val movieEntity =viewModel.getMovie(ID).value
        verify(movieRepository).getMovieDetail(ID)

        assertNotNull(movieEntity)

        //repeatly observe forever
        viewModel.getMovie(ID).observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(responseLive)
    }

    @Test
    fun getTV() {
        val tv = MutableLiveData<ResponseDetailTv>()
        val client = ApiConfig.getApiService().getDetailTV(ID_TV, API_KEY).execute()
        val response = client.body()
        val responseLive = response as ResponseDetailTv
        tv.value = responseLive

        Mockito.`when`(movieRepository.getTvDetail(ID_TV)).thenReturn(tv)
        val movieEntity =viewModel.getTV(ID_TV).value
        verify(movieRepository).getTvDetail(ID_TV)

        assertNotNull(movieEntity)

        //repeatly observe forever
        viewModel.getTV(ID_TV).observeForever(observerTv)
        Mockito.verify(observerTv).onChanged(responseLive)
    }
}