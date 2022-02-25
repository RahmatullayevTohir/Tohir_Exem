package com.example.tohir_exem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tohir_exem.adapter.CatigoryAdapter
import com.example.tohir_exem.adapter.CollactionAdapter
import com.example.tohir_exem.model.Catigory
import com.example.tohir_exem.model.Collection

class CollactionActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collaction)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this,1)

        refreshCollec(getAllCollec())
    }

    fun refreshCollec(items:ArrayList<Collection>){
        val adapter = CollactionAdapter(this, items)
        recyclerView!!.adapter = adapter
    }

    fun getAllCollec():ArrayList<Collection>{
        val heres:ArrayList<Collection> = ArrayList<Collection>()
        heres.add(Collection(R.drawable.im_photo1,"Kabab"))
        heres.add(Collection(R.drawable.im_photo2,"Kabab"))
        heres.add(Collection(R.drawable.im_photo3,"Kabab"))
        heres.add(Collection(R.drawable.im_photo4,"Kabab"))
        heres.add(Collection(R.drawable.im_photo2,"Kabab"))
        heres.add(Collection(R.drawable.im_photo4,"Kabab"))

        return heres
    }
}