package com.revmeapp.revme.ui.auth

import androidx.lifecycle.ViewModel
import com.revmeapp.revme.data.remote.model.LoginResponse
import com.revmeapp.revme.data.repository.AuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthViewModel : ViewModel() {

    var username: String? = null
    var password: String? = null
    var authListener: AuthListener? = null
    val repository = AuthRepository()


    fun onLoginButtonClick() {

        authListener?.onStarted()

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {

            authListener?.onFailure("Invalid username or password")

            return
        }

        repository.userLogin(username!!, password!!).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    authListener?.onSuccess()
                } else {
                    authListener?.onFailure("Login failed")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                authListener?.onFailure(t.message ?: "Unknown error")
            }
        })


    }

}
