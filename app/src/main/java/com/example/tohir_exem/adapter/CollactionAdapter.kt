package com.example.tohir_exem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tohir_exem.R
import com.example.tohir_exem.model.Collection

class CollactionAdapter(var context: Context, var items:ArrayList<Collection>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_collaction,parent,false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is CollectionViewHolder){
            var iv_image = holder.iv_image
            var tv_name = holder.tv_name

            iv_image.setImageResource(item.image)
            tv_name.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CollectionViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_image : ImageView
        var tv_name: TextView

        init {
            iv_image = view.findViewById(R.id.iv_collaction)
            tv_name = view.findViewById(R.id.tv_name)
        }
    }
}