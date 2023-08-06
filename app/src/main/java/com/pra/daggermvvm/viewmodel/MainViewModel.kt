package com.pra.daggermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pra.daggermvvm.model.Products
import com.pra.daggermvvm.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val productLiveData: LiveData<List<Products>> get() = repository.products


    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}