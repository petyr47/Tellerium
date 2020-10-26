package com.aneke.peter.tellerium.login

import com.aneke.peter.tellerium.data.PrefStore
import java.util.*

class LoginRepository(private val prefStore: PrefStore) {


    fun updateAsLogin() {
        prefStore.loginTime = Calendar.getInstance().timeInMillis
    }

}