package com.widyaanalytic.moviecatalogue.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.widyaanalytic.moviecatalogue.ui.movie.MovieFragment
import com.widyaanalytic.moviecatalogue.ui.tv.TvShowFragment

class PagerAdapter(fm: FragmentManager?, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(
    fm!!, lifecycle){
    override fun getItemCount(): Int {
        return numberOfTabs
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Movie Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Movie")
                val myOrderFragment = MovieFragment()
                myOrderFragment.arguments = bundle
                return myOrderFragment
            }
            1 -> {
                // # TvShow Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "TV Show")
                val historyFragment = TvShowFragment()
                historyFragment.arguments = bundle
                return historyFragment
            }
            else -> return HomeFragment()
        }
    }


}