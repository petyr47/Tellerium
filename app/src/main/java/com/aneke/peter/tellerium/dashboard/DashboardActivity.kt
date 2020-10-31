package com.aneke.peter.tellerium.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.aneke.peter.tellerium.R
import com.aneke.peter.tellerium.update.UpdateFarmerActivity
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
            val intent = Intent(this, UpdateFarmerActivity::class.java)
            intent.putExtra("id", farmer.id)
            startActivity(intent)
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