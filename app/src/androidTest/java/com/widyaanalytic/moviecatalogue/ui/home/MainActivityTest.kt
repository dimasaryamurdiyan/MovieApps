package com.widyaanalytic.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.data.source.remote.network.ApiConfig
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailMovie
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResponseDetailTv
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    companion object{
        private const val API_KEY = "94b1176a84b5c876a21900434bc4878a"
        private const val ID = "791373"
        private const val ID_TV = "88396"
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        ActivityScenario.launch(MainActivity::class.java)

    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
    }

    @Test
    fun loadDetailMovie(){
        val client = ApiConfig.getApiService().getDetailMovie(ID, API_KEY).execute()
        val response = client.body()
        val responseLive = response as ResponseDetailMovie
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(responseLive.originalTitle)))
        onView(withId(R.id.synopsis_value)).check(matches(isDisplayed()))
        onView(withId(R.id.synopsis_value)).check(matches(withText(responseLive.overview)))
    }

    @Test
    fun loadTvShows(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
    }

    @Test
    fun loadDetailTvShow(){
        val client = ApiConfig.getApiService().getDetailTV(ID_TV, API_KEY).execute()
        val response = client.body()
        val responseLive = response as ResponseDetailTv
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(responseLive.originalName)))
        onView(withId(R.id.synopsis_value)).check(matches(isDisplayed()))
        onView(withId(R.id.synopsis_value)).check(matches(withText(responseLive.overview)))
    }

}