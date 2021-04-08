package com.widyaanalytic.moviecatalogue.ui.favorite.tv

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.widyaanalytic.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.widyaanalytic.moviecatalogue.ui.favorite.movie.FavoriteMovieAdapter
import com.widyaanalytic.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel
import com.widyaanalytic.moviecatalogue.utils.ViewModelFactory


class FavoriteTvShowFragment : Fragment() {
    private var _fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _fragmentFavoriteTvShowBinding
    private lateinit var adapterTvShow: FavoriteTvShowAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteTvShowBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

        adapterTvShow = FavoriteTvShowAdapter()

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { movies ->
            Log.d("tv fav", movies.toString())
            if(movies != null){
                binding?.progressBar?.visibility = View.GONE
                adapterTvShow.setTvShows(movies)
                adapterTvShow.notifyDataSetChanged()
            }
        })

        binding?.rvFavoriteTve?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterTvShow
        }
    }

}