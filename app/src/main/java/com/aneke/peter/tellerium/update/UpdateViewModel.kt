package com.aneke.peter.tellerium.update

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aneke.peter.tellerium.network.models.Farmer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateViewModel(private val repository: UpdateRepository) : ViewModel() {

    val farmer = MutableLiveData<Farmer>()

    var id = 0

    val firstName = Transformations.map(farmer){it.first_name} as MutableLiveData<String>

    val middleName = Transformations.map(farmer){it.middle_name} as MutableLiveData<String>

    val surname = Transformations.map(farmer){it.surname} as MutableLiveData<String>

    val address = Transformations.map(farmer){it.address} as MutableLiveData<String>

    val email = Transformations.map(farmer){it.email_address} as MutableLiveData<String>

    val phone = Transformations.map(farmer){it.mobile_no} as MutableLiveData<String>

    val dob = Transformations.map(farmer){it.dob} as MutableLiveData<String>

    val occupation = Transformations.map(farmer){it.occupation} as MutableLiveData<String>

    var url = ""



    fun fetchFarmer(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            Log.e("update", "fetching for iid:::$id")
            val farmerOb = repository.fetchFarmerById(id)
            url = "${repository.imageUrl()}${farmerOb?.passport_photo}"
            Log.e("update", farmerOb.toString())
            farmer.postValue(farmerOb)
        }
    }


    fun updateFarmer(){
        GlobalScope.launch(Dispatchers.IO) {
            val address = address.value ?: " "
            val phone = phone.value ?: " "
            val email = email.value ?: " "
            val newFarmer = farmer.value!!.copy(isUpdated = true, address = address, email_address = email, mobile_no = phone)
            repository.updateFarmer(newFarmer)
        }
    }
}