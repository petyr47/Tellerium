package com.aneke.peter.tellerium.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aneke.peter.tellerium.R
import com.aneke.peter.tellerium.data.PrefStore
import com.aneke.peter.tellerium.network.models.Farmer
import kotlinx.android.synthetic.main.farmer_item.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class FarmerAdapter(private val context : Context) : RecyclerView.Adapter<FarmerAdapter.FarmerHolder>(), KoinComponent {

    lateinit var list : List<Farmer>

    private val prefStore : PrefStore by inject()

    private val base = prefStore.imageBaseUrl

    lateinit var onItemClicked : (Farmer) -> Unit

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): FarmerHolder =
            FarmerHolder(LayoutInflater.from(context).inflate(R.layout.farmer_item, container, false))

    override fun onBindViewHolder(holder: FarmerHolder, position: Int) =
            holder.bindFarmer(list[position])

    override fun getItemCount(): Int = list.size


    inner class FarmerHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindFarmer(farmer : Farmer) {
            val name = "${farmer.first_name} ${farmer.middle_name} ${farmer.surname}"
            itemView.item_address.text = "Address: ${farmer.address}"
            itemView.item_name.text = name
            val url = "${base}${farmer.passport_photo}"
            itemView.item_image.load(url)

            itemView.rootView.setOnClickListener {
                onItemClicked.invoke(farmer)
            }
        }
    }

}