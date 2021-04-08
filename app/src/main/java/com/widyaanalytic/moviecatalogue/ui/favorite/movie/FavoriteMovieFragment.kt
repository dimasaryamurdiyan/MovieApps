package com.widyaanalytic.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.widyaanalytic.moviecatalogue.databinding.FragmentMovieBinding
import com.widyaanalytic.moviecatalogue.ui.movie.MovieAdapter
import com.widyaanalytic.moviecatalogue.ui.movie.MovieViewModel
import com.widyaanalytic.moviecatalogue.utils.ViewModelFactory
import com.widyaanalytic.moviecatalogue.vo.Status


class FavoriteMovieFragment : Fragment() {
    private var _fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _fragmentFavoriteMovieBinding
    private lateinit var adapterMovie: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            _fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
            return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

        adapterMovie = FavoriteMovieAdapter()

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
            Log.d("tv fav", movies.toString())
            if(movies != null){
                binding?.progressBar?.visibility = View.GONE
                adapterMovie.setMovies(movies)
                adapterMovie.notifyDataSetChanged()
            }
        })

        binding?.rvFavoriteMovie?.layoutManager = LinearLayoutManager(context)
        binding?.rvFavoriteMovie?.setHasFixedSize(true)
        binding?.rvFavoriteMovie?.adapter = adapterMovie


    }

}