package com.revmeapp.revme.data.repository

import com.revmeapp.revme.data.remote.model.LoginRequest
import com.revmeapp.revme.data.remote.model.LoginResponse
import com.revmeapp.revme.data.remote.network.ApiService
import retrofit2.Call


class AuthRepository {
    private val api = ApiService()

    fun userLogin(username: String, password: String): Call<LoginResponse> {
        return api.userLogin(LoginRequest(username, password))
    }
}

