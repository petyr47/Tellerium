package com.aneke.peter.tellerium.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: DashboardRepository) : ViewModel() {

    val farmers = repository.observeDb()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.populateDb()
        }
    }
}