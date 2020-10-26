package com.aneke.peter.tellerium

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.aneke.peter.tellerium.dashboard.DashboardActivity
import com.aneke.peter.tellerium.data.PrefStore
import com.aneke.peter.tellerium.login.LoginActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val prefStore : PrefStore by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            resolveActivity()
        }, 3500)


    }


    private fun resolveActivity() {
        if (prefStore.isLoginValid()) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}