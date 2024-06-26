package com.revmeapp.revme.data.remote.network

import com.revmeapp.revme.data.remote.model.LoginRequest
import com.revmeapp.revme.data.remote.model.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    companion object {

        val IP = "192.168.1.3"

        val BASE_URL = "http://$IP:8000/api/"

        operator fun invoke(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

    @POST("auth/login/")
    fun userLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>
}