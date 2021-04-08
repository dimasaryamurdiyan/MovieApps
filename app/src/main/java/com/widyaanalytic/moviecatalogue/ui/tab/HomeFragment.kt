package com.widyaanalytic.moviecatalogue.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.widyaanalytic.moviecatalogue.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val binding get() = _fragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding?.viewPager as ViewPager2
        val tabs = binding?.tabs as TabLayout
        val numberOfTabs = 2
        val adapter = PagerAdapter(childFragmentManager, lifecycle, numberOfTabs)
        viewPager.adapter = adapter

        // Enable Swipe
        viewPager.isUserInputEnabled = true

        TabLayoutMediator(tabs, viewPager){tab, position ->
            when(position){
                0 -> {
                    tab.text = "Movie"
                }
                1 -> {
                    tab.text = "TV Show"
                }
            }
        }.attach()

//        binding?.tabs?.setupWithViewPager(binding?.viewPager)
    }
}