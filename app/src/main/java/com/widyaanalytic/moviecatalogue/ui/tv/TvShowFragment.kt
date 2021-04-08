package com.widyaanalytic.moviecatalogue.ui.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaanalytic.moviecatalogue.databinding.FragmentTvShowBinding
import com.widyaanalytic.moviecatalogue.utils.ViewModelFactory
import com.widyaanalytic.moviecatalogue.vo.Status


class TvShowFragment : Fragment() {
    private var _fragmentTvShowBinding: FragmentTvShowBinding ? = null
    private val binding get() = _fragmentTvShowBinding
    private lateinit var adapterTv: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]

        adapterTv = TvShowAdapter()
        viewModel.getTvShows().observe(viewLifecycleOwner, Observer { tvShows ->
            if(tvShows != null){
                when(tvShows.status){
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        adapterTv.setTvShows(tvShows.data)
                        adapterTv.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        with(binding?.rvTvShow){
            this?.layoutManager = LinearLayoutManager(context)
            this?.setHasFixedSize(true)
            this?.adapter = adapterTv
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _fragmentTvShowBinding = null
    }
}