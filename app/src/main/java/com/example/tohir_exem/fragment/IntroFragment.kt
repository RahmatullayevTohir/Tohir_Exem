package com.example.tohir_exem.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tohir_exem.R
import com.example.tohir_exem.model.Intro

class IntroFragment  : Fragment() {

    private val KEY: String = "the_key"

    fun newInstance(intro: Intro): IntroFragment {
        val fragment = IntroFragment()

        val bundle = Bundle()
        bundle.putSerializable(KEY, intro)

        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_for_view_pager, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        val photo: ImageView = view.findViewById(R.id.iv_icon)
        val title: TextView = view.findViewById(R.id.tv_title)
        val info: TextView = view.findViewById(R.id.tv_info)

        val intro = arguments?.getSerializable(KEY) as Intro

        photo.setImageResource(intro.icon)
        title.text = intro.title
        info.text = intro.info

    }

}