package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cronodepro.core.Constant
import com.example.inmovilla.core.Resource
import com.example.inmovilla.databinding.FragmentHomeBinding
import com.example.inmovilla.ui.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var adapter: HomeAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initListener()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.listHomes.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    println(it.message)
                }

                is Resource.Loading -> {

                    println("loading")

                }

                is Resource.Success -> {
                    if (it.data != null) {
                        println(it.data)
                        adapter.updateList(it.data)
                    }
                }
            }
        }
        viewModel.getHomes("Bearer ${Constant.AUTHO_JWT}")
    }

    private fun initListener() {
        initAdapter()
    }

    private fun initAdapter() {
        adapter = HomeAdapter(emptyList())
        binding.rvHomes.adapter = adapter
        binding.rvHomes.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}