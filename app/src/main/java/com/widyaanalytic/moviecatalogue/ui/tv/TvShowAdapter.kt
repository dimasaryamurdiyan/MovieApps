package com.widyaanalytic.moviecatalogue.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.data.TVShowEntity
import com.widyaanalytic.moviecatalogue.data.source.local.entity.TvEntity
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsItem
import com.widyaanalytic.moviecatalogue.data.source.remote.response.ResultsMovie
import com.widyaanalytic.moviecatalogue.databinding.ItemsTvShowBinding
import com.widyaanalytic.moviecatalogue.ui.detail.DetailMovieTvActivity

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvViewHolder>() {
    private var listTvShow = ArrayList<TvEntity>()

    fun setTvShows(tvs: List<TvEntity>?){
        if(tvs == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvViewHolder {
        val itemsTvShowBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemsTvShowBinding)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowAdapter.TvViewHolder, position: Int) {
        val tv = listTvShow[position]
        holder.bind(tv)
    }

    class TvViewHolder(private val binding: ItemsTvShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvEntity){
            with(binding){
                tvItemTitle.text = tv.originalName
                tvItemSynopsis.text = tv.overview
                Glide.with(itemView.context)
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"+tv.posterPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
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
    fun updateTvList(tvList: List<TvEntity>){
        listTvShow = tvList as ArrayList<TvEntity>
        notifyDataSetChanged()
    }
}