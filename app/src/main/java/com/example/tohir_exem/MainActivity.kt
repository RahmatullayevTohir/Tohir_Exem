package com.example.tohir_exem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tohir_exem.adapter.CatigoryAdapter
import com.example.tohir_exem.adapter.RestaurantAdapter
import com.example.tohir_exem.model.Catigory
import com.example.tohir_exem.model.Restaurant

class MainActivity : AppCompatActivity() {

    lateinit var rv_catigory :RecyclerView
    lateinit var rv_restaurant :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        rv_catigory = findViewById(R.id.rv_catigories)
        rv_restaurant = findViewById(R.id.rv_restaurants)

        rv_catigory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_restaurant.layoutManager = GridLayoutManager(this,2)

        refreshAdapterCatigory(getAllCatigory())
        refreshAdapterRestaurant(getAllRestaurant())


        val iv_collection = findViewById<ImageView>(R.id.iv_collection)
        iv_collection.setOnClickListener { openCollectionActivity() }
    }

    fun openCollectionActivity(){
        var intent = Intent(this, CollactionActivity::class.java)
        startActivity(intent)
    }

    fun refreshAdapterCatigory(heres:ArrayList<Catigory>){
        val adapter = CatigoryAdapter(this, heres)
        rv_catigory!!.adapter = adapter
    }

    fun getAllCatigory():ArrayList<Catigory>{
        val heres:ArrayList<Catigory> = ArrayList<Catigory>()
        heres.add(Catigory(R.drawable.im_photo1,"Kabab"))
        heres.add(Catigory(R.drawable.im_photo2,"Barbikyu"))
        heres.add(Catigory(R.drawable.im_photo3,"Fish"))
        heres.add(Catigory(R.drawable.im_photo4,"Coffee"))
        heres.add(Catigory(R.drawable.im_photo1,"Kabab"))
        heres.add(Catigory(R.drawable.im_photo2,"Kabab"))
        heres.add(Catigory(R.drawable.im_photo3,"Kabab"))
        return heres
    }

    fun refreshAdapterRestaurant(feeds:ArrayList<Restaurant>){
        val adapter = RestaurantAdapter(this, feeds)
        rv_restaurant!!.adapter = adapter
    }

    fun getAllRestaurant():ArrayList<Restaurant>{
        val feeds: ArrayList<Restaurant> = ArrayList<Restaurant>()
        feeds.add(Restaurant(R.drawable.im_photo1,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo2,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo3,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo4,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo1,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo2,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo3,"Barbikyu","Navoiy 1254"))
        feeds.add(Restaurant(R.drawable.im_photo4,"Barbikyu","Navoiy 1254"))
        return feeds
    }
}