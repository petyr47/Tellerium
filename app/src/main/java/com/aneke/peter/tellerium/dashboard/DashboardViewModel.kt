package com.aneke.peter.tellerium.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: DashboardRepository) : ViewModel() {

    val farmers = repository.observeDb()

    val captured = MutableLiveData<String>().apply {
        value = "0"
    }

    val area = MutableLiveData<String>().apply {
        value = "0"
    }

    val updated = Transformations.map(farmers){it.filter { it.isUpdated }.size.toString()}


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.populateDb()
        }
    }
}