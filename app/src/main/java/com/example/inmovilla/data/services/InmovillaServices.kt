package com.example.inmovilla.data.services

import com.example.inmovilla.data.model.Login.LoginDTO
import com.example.inmovilla.data.model.home.HomeDTO
import com.example.shinyapplication.domain.model.login.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface InmovillaServices {
    @POST("auth/auth/login")
    suspend fun getAuthLogin(@Body login: Login): Response<LoginDTO>
    @GET("home")
    suspend fun getHomes(@Header("Authorization") jwt: String):Response<HomeDTO>
}