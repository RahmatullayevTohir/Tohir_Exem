package com.example.tohir_exem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tohir_exem.R
import com.example.tohir_exem.model.Restaurant

class RestaurantAdapter(var context: Context, var items: ArrayList<Restaurant>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_menu,parent,false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is RestaurantViewHolder){
            var iv_foods = holder.iv_foods
            var tv_food_name = holder.tv_food_name
            var tv_location = holder.tv_location

            iv_foods.setImageResource(item.image)
            tv_food_name.text = item.foodName
            tv_location.text = item.location
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RestaurantViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_foods:ImageView
        var tv_food_name:TextView
        var tv_location:TextView

        init {
            iv_foods = view.findViewById(R.id.iv_foods)
            tv_food_name = view.findViewById(R.id.tv_food_name)
            tv_location = view.findViewById(R.id.tv_location)
        }
    }

    class CatigoryViewHolder(view: View):RecyclerView.ViewHolder(view){

        var iv_image :ImageView
        var tv_name:TextView

        init {

            iv_image = view.findViewById(R.id.iv_catigory)
            tv_name = view.findViewById(R.id.tv_name)
        }
    }
}