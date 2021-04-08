package com.widyaanalytic.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.data.source.local.entity.MovieEntity
import com.widyaanalytic.moviecatalogue.databinding.ItemsMovieBinding
import com.widyaanalytic.moviecatalogue.ui.detail.DetailMovieTvActivity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieEntity>()
    fun setMovies(movies: List<MovieEntity>?){
        if(movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieEntity){
            with(binding){
                tvItemTitle.text = movie.originalTitle
                tvItemSynopsis.text = movie.overview
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieTvActivity::class.java)
                    intent.putExtra(DetailMovieTvActivity.ID_MOVIE, movie.id.toString())
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"+movie.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    fun updateMovieList(movieList: List<MovieEntity>){
        listMovie = movieList as ArrayList<MovieEntity>
        notifyDataSetChanged()
    }
}