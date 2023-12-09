package com.example.inmovilla.data.model.Login

data class User(
    val email: String,
    val exp: Int,
    val iat: Int,
    val id: Int,
    val names: String,
    val role: Int
)