package com.aneke.peter.tellerium.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aneke.peter.tellerium.util.isEmailValid

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {


    val userName = MutableLiveData<String>()
    val errorMessage = MutableLiveData<String>()
    val password = MutableLiveData<String>()


    private fun validateFields() : Boolean{
        if (userName.value.isNullOrBlank()){
            errorMessage.value = "Email cannot be blank"
            return false
        }
        if (userName.value.isEmailValid()){
            errorMessage.value = "Please enter a valid email"
            return false
        }
        if (password.value.isNullOrBlank()){
            errorMessage.value = "Password cannot be blank"
            return false
        }
        return true
    }

    fun loginClicked() {
        if (validateFields()) {

        }
    }

}