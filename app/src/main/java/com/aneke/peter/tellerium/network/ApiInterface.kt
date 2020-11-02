package com.aneke.peter.tellerium.network

import com.aneke.peter.tellerium.network.models.FetchFarmerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("get-sample-farmers")
    suspend fun fetchFarmers(@Query("limit") limit : Int = 50) : FetchFarmerResponse
}