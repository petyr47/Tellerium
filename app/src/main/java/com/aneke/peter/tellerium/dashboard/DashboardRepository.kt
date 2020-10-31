package com.aneke.peter.tellerium.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aneke.peter.tellerium.data.AppDatabase
import com.aneke.peter.tellerium.data.PrefStore
import com.aneke.peter.tellerium.data.Resource
import com.aneke.peter.tellerium.network.ApiInterface
import com.aneke.peter.tellerium.network.models.Farmer
import retrofit2.HttpException
import java.net.UnknownHostException

class DashboardRepository(private val service : ApiInterface,
                          db : AppDatabase,
                          private val prefStore: PrefStore) {

    private val dao = db.farmerDao()




    suspend fun populateDb() : Resource<Boolean> {
        try {
            val result = service.fetchFarmers()
            if (result.status == "true") {
                val farmers = result.data.farmers
                dao.insertFarmers(farmers)
                val imageBase = result.data.imageBaseUrl
                prefStore.imageBaseUrl = imageBase
                return Resource.success(true, "Data updated successfully")
            } else {
               return Resource.error("An Error occurred while fetching farmers")
            }
        } catch (e : Exception) {
            e.printStackTrace()
            if (e is HttpException || e is UnknownHostException) {
                return Resource.error("A Network Error occurred, Please check your internet connection")
            }
            return Resource.error(e.message)
        }
    }

    fun observeDb() : LiveData<List<Farmer>> {
        try {
            return dao.observeAllFarmers()
        } catch (e : Exception) {
            e.printStackTrace()
            return MutableLiveData(listOf())
        }
    }
}