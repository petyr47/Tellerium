package com.aneke.peter.tellerium.update

import com.aneke.peter.tellerium.data.AppDatabase

class UpdateRepository(db : AppDatabase) {

    private val dao = db.farmerDao()

}