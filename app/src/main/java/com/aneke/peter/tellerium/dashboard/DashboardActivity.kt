package com.aneke.peter.tellerium.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.aneke.peter.tellerium.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {

    private val viewModel : DashboardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val adapter = FarmerAdapter(this)
        adapter.list = listOf()
        adapter.onItemClicked = { farmer ->  
            
        }
        farmer_list.adapter = adapter


        viewModel.farmers.observe(this, Observer {
            it?.let {list ->
                adapter.list = list
                adapter.notifyDataSetChanged()
            }
        })

    }
}