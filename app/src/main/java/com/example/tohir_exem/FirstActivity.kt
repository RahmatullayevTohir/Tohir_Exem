package com.example.tohir_exem

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.tohir_exem.adapter.ViewPagerAdapter
import com.example.tohir_exem.fragment.IntroFragment
import com.example.tohir_exem.manager.SharedPref
import com.example.tohir_exem.model.Intro
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class FirstActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var indicator: SpringDotsIndicator
    private lateinit var tvSkip: TextView
    private lateinit var tvNext: TextView
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        if (SharedPref(this).isSaved) {
            openRestaurantActivity()
        }

    }

    private fun initViews() {
        indicator = findViewById(R.id.springDotsIndicator)
        tvSkip = findViewById(R.id.tv_skip)
        tvNext = findViewById(R.id.tv_next)
        context = this

        viewPager = findViewById(R.id.viewPager)
        pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        addAllFragment()
        viewPager.adapter = pagerAdapter
        indicator.setViewPager(viewPager)

        changeViewPagerItem()

    }

    private fun addAllFragment() {
        pagerAdapter.add(
            IntroFragment().newInstance(
                Intro(
                    R.drawable.heart,
                    "Saved Listings",
                    "Save your favourite listings to come back to them later."
                )
            )
        )
        pagerAdapter.add(
            IntroFragment().newInstance(
                Intro(
                    R.drawable.instagram,
                    "Add New Listings",
                    "Add new listings directly from the app, including photo gallery and filters."
                )
            )
        )
        pagerAdapter.add(
            IntroFragment().newInstance(
                Intro(
                    R.drawable.chat,
                    "Chat",
                    "Communicate with your customers and vendors in real-time."
                )
            )
        )
        pagerAdapter.add(
            IntroFragment().newInstance(
                Intro(
                    R.drawable.notification,
                    "Get notified",
                    "Stay on top of your game with real-time push notifications."
                )
            )
        )
    }

    private fun changeViewPagerItem() {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                when (position) {
                    1 -> {
                        tvSkip.visibility = View.VISIBLE
                        tvNext.text = "Next"
                        tvSkip.setOnClickListener {
                            finish()
                        }
                        tvNext.setOnClickListener {
                            viewPager.setCurrentItem(2, true)
                        }
                    }
                    2 -> {
                        tvSkip.visibility = View.VISIBLE
                        tvNext.text = "Next"
                        tvSkip.setOnClickListener {
                            finish()
                        }
                        tvNext.setOnClickListener {
                            viewPager.setCurrentItem(3, true)
                        }
                    }
                    3 -> {
                        tvSkip.visibility = View.GONE
                        tvNext.text = "Done"
                        tvNext.setOnClickListener {
                            SharedPref(context).isSaved = true
                            openRestaurantActivity()
                        }
                    }
                    else -> {
                        tvSkip.visibility = View.VISIBLE
                        tvNext.text = "Next"
                        tvSkip.setOnClickListener {
                            finish()
                        }
                        tvNext.setOnClickListener {
                            viewPager.setCurrentItem(1, true)
                        }
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun openRestaurantActivity() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}