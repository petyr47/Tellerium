package com.aneke.peter.tellerium.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.aneke.peter.tellerium.R
import com.aneke.peter.tellerium.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    private val loginViewModel : LoginViewModel by viewModel()
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = loginViewModel

        loginViewModel.errorMessage.observe(this, Observer {
            it?.let { message ->
                showMessage(message)
            }
        })
    }


    private fun showMessage(message : String) {
        val builder = AlertDialog.Builder(this).apply {
            setTitle("Attention")
            setMessage(message)
            setPositiveButton("OK"){ dialog, _ ->
                dialog.dismiss()
            }
        }
        if (!isFinishing) {
            val dialog = builder.create()
            dialog.show()
        }
    }
}