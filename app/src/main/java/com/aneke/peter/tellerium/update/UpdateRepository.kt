package com.aneke.peter.tellerium.update

import com.aneke.peter.tellerium.data.AppDatabase
import com.aneke.peter.tellerium.data.PrefStore
import com.aneke.peter.tellerium.network.models.Farmer

class UpdateRepository(db : AppDatabase, private val prefStore: PrefStore) {

    private val dao = db.farmerDao()

    suspend fun fetchFarmerById(id : Int) : Farmer? {
        try {
           return dao.fetchFarmerWithId(id).single { it.id == id }
        } catch (e : Exception){
            e.printStackTrace()
            return null
        }
    }

    fun imageUrl() = prefStore.imageBaseUrl

    suspend fun updateFarmer(farmer: Farmer) : Boolean {
        try {
            dao.updateFarmer(farmer)
            return true
        } catch (e : Exception) {
            e.printStackTrace()
            return false
        }
    }

}