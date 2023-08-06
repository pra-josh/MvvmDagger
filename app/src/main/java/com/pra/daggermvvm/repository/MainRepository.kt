package com.pra.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pra.daggermvvm.api.WebApi
import com.pra.daggermvvm.model.Products
import javax.inject.Inject

class MainRepository @Inject constructor(private val webApi: WebApi) {

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>  get() = _products

    suspend fun getProducts() {
        val result = webApi.getProducts()
        if(result.isSuccessful && result.body()!=null){
            _products.postValue(result.body())
        }
    }
}