package com.example.inmovilla.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.inmovilla.data.model.home.Data
import com.example.inmovilla.databinding.ItemHomeBinding

class HomeViewHolder(private var binding:ItemHomeBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Data) {
        binding.Direccion.text = item.Direccion
    }
}