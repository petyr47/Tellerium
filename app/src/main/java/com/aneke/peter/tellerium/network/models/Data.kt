package com.aneke.peter.tellerium.network.models

data class Data(
    val farmers: List<Farmer>,
    val imageBaseUrl: String,
    val totalRec: Int
)