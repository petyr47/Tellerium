package com.aneke.peter.tellerium.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aneke.peter.tellerium.R
import org.koin.android.ext.android.inject

class UpdateFarmerActivity : AppCompatActivity() {

    private val viewModel : UpdateViewModel by inject()

    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_farmer)

        id = intent.getIntExtra("id", 0)
    }
}