package com.widyaanalytic.moviecatalogue.ui.favorite.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.databinding.ItemsFavoriteTvShowBinding
import com.widyaanalytic.moviecatalogue.ui.detail.DetailMovieTvActivity

class FavoriteTvShowAdapter: RecyclerView.Adapter<FavoriteTvShowAdapter.FavoriteTvViewHolder>() {
   private var listFavoriteTvShow = ArrayList<TvEntity>()

    fun setTvShows(tvs: List<TvEntity>?){
        if(tvs == null) return
        this.listFavoriteTvShow.clear()
        this.listFavoriteTvShow.addAll(tvs)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvViewHolder {
        val itemsFavoriteTvShowBinding = ItemsFavoriteTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvViewHolder(itemsFavoriteTvShowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvViewHolder, position: Int) {
        val tv = listFavoriteTvShow[position]
        holder.bind(tv)
    }

    override fun getItemCount(): Int = listFavoriteTvShow.size


    class FavoriteTvViewHolder(private val binding: ItemsFavoriteTvShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvEntity){
            with(binding){
                tvItemTitle.text = tv.originalName
                tvItemSynopsis.text = tv.overview
                Glide.with(itemView.context)
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"+tv.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieTvActivity::class.java)
                    intent.putExtra(DetailMovieTvActivity.ID_TV, tv.id.toString())
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}