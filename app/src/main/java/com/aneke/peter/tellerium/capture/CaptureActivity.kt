package com.aneke.peter.tellerium.capture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aneke.peter.tellerium.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CaptureActivity : AppCompatActivity() {

    private val viewModel : CaptureViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture)
    }
}