package com.example.pickeat

import com.example.pickeat.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rest_view_holder.view.*

class ZomatoAdapter(var restaurants: List<Restaurant>) : RecyclerView.Adapter<ZomatoAdapter.ZomatoViewHolder>(){

    fun loadNewData(newRestaurant : List<Restaurant>) {
        restaurants = newRestaurant
        notifyItemInserted(restaurants.lastIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZomatoViewHolder {
            val v = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rest_view_holder, parent, false)

        return ZomatoViewHolder(v)
    }

    override fun getItemCount() = restaurants.size

    override fun onBindViewHolder(holder: ZomatoViewHolder, position: Int) {
        holder.setUpForItem(restaurants[position])
    }

    class ZomatoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setUpForItem(restaurant: Restaurant) {
            itemView.text_view_rest.text = restaurant.name
        }
    }


}