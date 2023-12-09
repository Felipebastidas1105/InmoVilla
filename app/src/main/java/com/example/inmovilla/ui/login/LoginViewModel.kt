package com.example.inmovilla.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inmovilla.core.Resource
import com.example.inmovilla.data.model.Login.LoginDTO
import com.example.inmovilla.domain.repository.InmoVillaRepository
import com.example.shinyapplication.domain.model.login.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val inmovillaReposity: InmoVillaRepository) :
    ViewModel() {

    val authLogin = MutableLiveData<Resource<LoginDTO>>()
    fun getAuthLogin(login: Login) {
        authLogin.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            authLogin.postValue(inmovillaReposity.getAuthLogin(login))
        }
    }

}