package com.aneke.peter.tellerium.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aneke.peter.tellerium.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}