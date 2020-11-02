package com.aneke.peter.tellerium.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmer_table")
data class Farmer(

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,

    val address: String,
    val bvn: String,
    val city: String,
    val dob: String,
    val email_address: String,
    val expiry_date: String,
    val farmer_id: String,
    val fingerprint: String,
    val first_name: String,
    val gender: String,
    val id_image: String,
    val id_no: String,
    val id_type: String,
    val issue_date: String,
    val lga: String,
    val marital_status: String,
    val middle_name: String,
    val mobile_no: String,
    val nationality: String,
    val occupation: String,
    val passport_photo: String,
    val reg_no: String,
    val spouse_name: String,
    val state: String,
    val surname: String,

    //
    var isUpdated : Boolean = false,
    var newImageId : String = "",
    var newPassport : String = ""

)