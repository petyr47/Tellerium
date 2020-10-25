package com.aneke.peter.tellerium.data

import android.content.Context
import android.content.SharedPreferences

const val SHARED_PREF = "shared_pref"
const val IMAGE_BASE_URL = "image_base_url"

class PrefStore (private val context : Context) {


    private val sharedPref: SharedPreferences by lazy { context.getSharedPreferences(SHARED_PREF,
        Context.MODE_PRIVATE
    ) }

    private val editor: SharedPreferences.Editor = sharedPref.edit()

    var imageBaseUrl : String
        set(value) = editor.putString(IMAGE_BASE_URL,value).apply()
        get() = sharedPref.getString(IMAGE_BASE_URL, "") ?: ""
}