package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inmovilla.core.Resource
import com.example.inmovilla.data.model.home.Data
import com.example.inmovilla.data.model.home.HomeDTO
import com.example.inmovilla.domain.repository.InmoVillaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val inmoVillaRepository: InmoVillaRepository) :
    ViewModel() {

    val listHomes = MutableLiveData<Resource<List<Data>>>()

    fun getHomes(jwt: String) {
        listHomes.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            listHomes.postValue(inmoVillaRepository.getHomes(jwt))
        }
    }

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
}