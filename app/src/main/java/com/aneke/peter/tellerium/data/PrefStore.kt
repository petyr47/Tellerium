package com.aneke.peter.tellerium.data

import android.content.Context
import android.content.SharedPreferences
import java.util.*

const val SHARED_PREF = "shared_pref"
const val IMAGE_BASE_URL = "image_base_url"
const val LAST_LOGIN_TIME = "login_time"
const val FIRST_RUN="first_run"
const val SESSION_LENGTH = 30 * 60 * 1000 //30 minutes

class PrefStore (private val context : Context) {


    private val sharedPref: SharedPreferences by lazy { context.getSharedPreferences(SHARED_PREF,
        Context.MODE_PRIVATE
    ) }

    private val editor: SharedPreferences.Editor = sharedPref.edit()

    var imageBaseUrl : String
        set(value) = editor.putString(IMAGE_BASE_URL,value).apply()
        get() = sharedPref.getString(IMAGE_BASE_URL, "") ?: ""

    var loginTime : Long
        set(value) = editor.putLong(LAST_LOGIN_TIME, value).apply()
        get() = sharedPref.getLong(LAST_LOGIN_TIME, 0)

    var firstRun : Boolean
        set(value) = editor.putBoolean(FIRST_RUN, value).apply()
        get() = sharedPref.getBoolean(FIRST_RUN, false)



    fun isLoginValid() : Boolean {
        val currentTime = Calendar.getInstance().timeInMillis
        val difference = currentTime - loginTime
        return SESSION_LENGTH > difference
    }
}