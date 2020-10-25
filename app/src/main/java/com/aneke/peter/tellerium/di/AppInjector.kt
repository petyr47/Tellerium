package com.aneke.peter.tellerium.di

import com.aneke.peter.tellerium.data.PrefStore
import com.aneke.peter.tellerium.network.RetrofitClient
import org.koin.dsl.module

private val dataModule = module {
    single { RetrofitClient.makeApiService() }
    single { PrefStore(get()) }

}

private val repositoryModule = module {

}

private val viewModels = module {

}


val modules = listOf(dataModule, repositoryModule, viewModels)