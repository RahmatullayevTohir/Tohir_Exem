package com.example.tohir_exem.manager

import android.content.Context
import androidx.core.content.edit

class SharedPref(context: Context) {

    private val pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    var isSaved: Boolean
        get() = pref.getBoolean("isSaved", false)
        set(value) = pref.edit { this.putBoolean("isSaved", value) }

}