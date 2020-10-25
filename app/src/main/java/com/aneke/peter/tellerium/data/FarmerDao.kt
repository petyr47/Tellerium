package com.aneke.peter.tellerium.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aneke.peter.tellerium.network.models.Farmer

@Dao
interface FarmerDao {

    @Insert
    suspend fun insertFarmer(farmer: Farmer)

    @Insert
    suspend fun insertFarmers(list: List<Farmer>)

    @Update
    suspend fun updateFarmer(farmer: Farmer)

    @Update
    suspend fun updateFarmers(list: List<Farmer>)

    @Query("DELETE FROM farmer_table")
    suspend fun clearFarmerTable()

    @Query("SELECT * FROM farmer_table")
    suspend fun fetchAllFarmers(): List<Farmer>

    @Query("SELECT * FROM farmer_table")
    fun observeAllFarmers(): LiveData<List<Farmer>>

    @Query("SELECT * FROM farmer_table WHERE id = :id")
    suspend fun fetchFarmerWithId(id: Int): List<Farmer>

    @Query("SELECT * FROM farmer_table WHERE id = :id")
    fun observeFarmerWithId(id: Int): LiveData<List<Farmer>>

}