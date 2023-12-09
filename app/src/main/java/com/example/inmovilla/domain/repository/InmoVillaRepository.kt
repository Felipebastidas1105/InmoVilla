package com.example.inmovilla.domain.repository

import com.example.inmovilla.core.Resource
import com.example.inmovilla.data.model.Login.LoginDTO
import com.example.inmovilla.data.model.home.Data
import com.example.inmovilla.data.services.InmovillaServices
import com.example.shinyapplication.domain.model.login.Login
import javax.inject.Inject

class InmoVillaRepository @Inject constructor(private val inmovillaServices: InmovillaServices){

    suspend fun getAuthLogin(login: Login): Resource<LoginDTO> {
        try {
            val res = inmovillaServices.getAuthLogin(login = login)
            if (res.isSuccessful) {
                val body = res.body()
                body?.let {
                    return Resource.Success(body)
                }
            }
            return  Resource.Error("Error in the service")
        }catch (e:Exception){
            return  Resource.Error("Error: {${e.message}}")
        }
    }


   suspend fun getHomes(jwt:String): Resource<List<Data>> {
        try {
            val res = inmovillaServices.getHomes(jwt)
            if (res.isSuccessful){
                val body = res.body()
                body?.let {
                    return Resource.Success(body.data)
                }
            }
            return  Resource.Error("Error in the service")
        }catch (e:Exception){
            return  Resource.Error("Error ${e.message}")
        }
    }
}