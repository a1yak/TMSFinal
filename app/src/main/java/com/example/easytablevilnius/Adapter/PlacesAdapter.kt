package com.example.easytablevilnius.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easytablevilnius.Models.FoodPlace
import com.example.easytablevilnius.R

class PlacesAdapter:RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>() {

    private val placesList = ArrayList<FoodPlace>()

    class PlacesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.tv_placename)
        val adress : TextView = itemView.findViewById(R.id.tv_adress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.places_item,parent, false)
        return PlacesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        val currentitem = placesList[position]
        holder.name.text = currentitem.name
        holder.adress.text = currentitem.adress
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    fun updateList(placeList: List<FoodPlace>){
        this.placesList.clear()
        this.placesList.addAll(placeList)
        notifyDataSetChanged()
    }
}