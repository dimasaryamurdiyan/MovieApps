package com.widyaanalytic.moviecatalogue.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.widyaanalytic.moviecatalogue.R
import com.widyaanalytic.moviecatalogue.databinding.FragmentFavoriteBinding
import com.widyaanalytic.moviecatalogue.ui.home.SectionPagerAdapter


class FavoriteFragment : Fragment() {

    private var _fragmentFavoriteBinding: FragmentFavoriteBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = context?.let { SectionPagerAdapter(it, childFragmentManager) }
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)


    }
    override fun onDestroy() {
        super.onDestroy()
        _fragmentFavoriteBinding = null
    }

}