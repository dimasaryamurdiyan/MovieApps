package com.widyaanalytic.moviecatalogue.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.ui.favorite.movie.FavoriteMovieFragment
import com.widyaanalytic.moviecatalogue.ui.favorite.tv.FavoriteTvShowFragment
import com.widyaanalytic.moviecatalogue.ui.movie.MovieFragment
import com.widyaanalytic.moviecatalogue.ui.tv.TvShowFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv)
    }

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        TAB_TITLES[position])
}