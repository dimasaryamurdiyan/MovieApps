package com.widyaanalytic.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.databinding.ActivityDetailMovieTvBinding
import com.widyaanalytic.moviecatalogue.utils.ViewModelFactory
import com.widyaanalytic.moviecatalogue.vo.Status

class DetailMovieTvActivity : AppCompatActivity() {
    companion object{
        const val ID_MOVIE = "id_movie"
        const val ID_TV = "id_tv"
    }

    private lateinit var activityDetailMovieTvBinding: ActivityDetailMovieTvBinding
    private lateinit var viewModel: DetailMovieTvViewModel
    private  var idTv: String? = null
    private  var idMovie: String? = null
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieTvBinding = ActivityDetailMovieTvBinding.inflate(layoutInflater)
        setContentView(activityDetailMovieTvBinding.root)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieTvViewModel::class.java]

        val extras = intent.extras
        if(extras != null){
            idTv = extras.getString(ID_TV)
            idMovie = extras.getString(ID_MOVIE)
            if(idMovie != null){
                viewModel.setSelectedData(idMovie!!)
                viewModel.movies.observe(this, Observer {
                    val genreList = it.data?.genre
                    val voteAverage = it.data?.voteAverage
                    with(activityDetailMovieTvBinding){
                        tvTitle.text = it.data?.originalTitle
                        if (voteAverage != null) {
                            rateBar.rating = voteAverage.toFloat().div(2)
                        }
                        Log.d("tes", genreList.toString())
                        genreValue.text = genreList.toString()
                        tvSynopsis.text = getString(R.string.synopsis_text)
                        tvGenre.text = getString(R.string.genre)
                        tvRating.text = getString(R.string.rating)
                        tvEpisode.visibility = View.GONE
                        episodeValue.visibility = View.GONE
                        synopsisValue.text = it.data?.overview
                        Glide.with(this@DetailMovieTvActivity)
                                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"+it.data?.posterPath)
                                .transform(RoundedCorners(10))
                                .apply(
                                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                                .error(R.drawable.ic_error))
                                .into(imageValue)
                    }
                })
            }
            if(idTv != null){
                viewModel.setSelectedData(idTv!!)
                viewModel.tv.observe(this, Observer {
                    val genreList = it.data?.genre
                    val voteAverage = it.data?.voteAverage
                    with(activityDetailMovieTvBinding){
                        tvTitle.text = it.data?.originalName
                        if (voteAverage != null) {
                            rateBar.rating = voteAverage.toFloat().div(2)
                        }
                        genreValue.text = genreList.toString()
                        episodeValue.text = it.data?.episodes.toString() + " Episodes"
                        synopsisValue.text = it.data?.overview
                        tvSynopsis.text = getString(R.string.synopsis_text)
                        tvGenre.text = getString(R.string.genre)
                        tvRating.text = getString(R.string.rating)
                        tvEpisode.text = "Episodes"
                        Glide.with(this@DetailMovieTvActivity)
                                .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"+it.data?.posterPath)
                                .transform(RoundedCorners(10))
                                .apply(
                                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                                .error(R.drawable.ic_error))
                                .into(imageValue)
                    }
                })
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu

        if(idMovie != null){
            viewModel.movies.observe(this,{ movie ->
                if(movie != null){
                    when(movie.status){
//                        Status.LOADING -> activityDetailMovieTvBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (movie.data != null) {
//                            activityDetailMovieTvBinding.progressBar.visibility = View.GONE
                            val state = movie.data.favorite
                            Log.d("state", state.toString())
                            setBookmarkState(state)
                        }
                        Status.ERROR -> {
//                            activityDetailMovieTvBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        if(idTv!=null){
            viewModel.tv.observe(this,{ tv->
                if(tv != null){
                    when(tv.status){
//                        Status.LOADING -> activityDetailMovieTvBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (tv.data != null) {
//                            activityDetailMovieTvBinding.progressBar.visibility = View.GONE
                            val state = tv.data.favorite
                            Log.d("state", state.toString())
                            setBookmarkState(state)
                        }
                        Status.ERROR -> {
//                            activityDetailMovieTvBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_favorite){
            Log.d("state", "mas")
            if(idMovie != null){
                Log.d("state", idMovie.toString())
                viewModel.setFavoritedMovie()
            }
            if(idTv!=null){
                viewModel.setFavoritedTvShow()
            }
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }

}