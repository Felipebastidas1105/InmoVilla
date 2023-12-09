package com.example.inmovilla.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inmovilla.data.model.home.Data
import com.example.inmovilla.databinding.ItemHomeBinding

class HomeAdapter (private var listHomes:List<Data> ) : RecyclerView.Adapter<HomeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int= listHomes.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = listHomes[position]
        holder.bind(item)
    }
    fun updateList(newList:List<Data>) {
        listHomes = newList
        notifyDataSetChanged()
    }

}