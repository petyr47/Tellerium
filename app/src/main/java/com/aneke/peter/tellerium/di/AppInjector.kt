package com.aneke.peter.tellerium.di

import com.aneke.peter.tellerium.data.AppDatabase
import com.aneke.peter.tellerium.data.PrefStore
import com.aneke.peter.tellerium.login.LoginRepository
import com.aneke.peter.tellerium.login.LoginViewModel
import com.aneke.peter.tellerium.network.RetrofitClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val dataModule = module {
    single { RetrofitClient.makeApiService() }
    single { PrefStore(get()) }
    single { AppDatabase.getInstance(get()) }
}

private val repositoryModule = module {
    single { LoginRepository(get()) }

}

private val viewModels = module {
    viewModel { LoginViewModel(get()) }

}


val modules = listOf(dataModule, repositoryModule, viewModels)