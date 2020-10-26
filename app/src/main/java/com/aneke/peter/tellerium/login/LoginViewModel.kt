package com.aneke.peter.tellerium.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aneke.peter.tellerium.util.isEmailValid

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {


    val userName = MutableLiveData<String>()
    val errorMessage = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val userVerified = MutableLiveData<Boolean>().apply { value = false }

    private val correctEmail = "test@tellerium.io"
    private val correctPassword = "password"


    private fun validateFields() : Boolean{
        if (userName.value.isNullOrBlank()){
            errorMessage.value = "Email cannot be blank"
            return false
        }
        if (!userName.value.isEmailValid()){
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
            if (authenicateUser()) {
                userVerified.value = true
                 repository.updateAsLogin()
            } else {
                errorMessage.value = "Incorrect Credentials!!"
            }
        }
    }

    private fun authenicateUser() : Boolean {
        return if (userName.value?.trim()?.equals(correctEmail, true) == true) {
            password.value?.trim()?.equals(correctPassword, true) ?: false
        } else {
            false
        }

    }

}