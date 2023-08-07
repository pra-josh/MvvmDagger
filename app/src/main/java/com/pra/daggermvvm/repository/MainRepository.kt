package com.pra.daggermvvm.repository

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pra.daggermvvm.api.WebApi
import com.pra.daggermvvm.db.AppDb
import com.pra.daggermvvm.model.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val webApi: WebApi, private val appDb: AppDb
) {

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> get() = _products

    suspend fun getProducts() {
        val result = webApi.getProducts()
        if (result.isSuccessful && result.body() != null) {
            val async = CoroutineScope(Dispatchers.IO).async {
                appDb.productDao().saveProducts(result.body()!!)
            }
            async.await()
            CoroutineScope(Dispatchers.IO).launch {
                _products.postValue(appDb.productDao().getAllUser())
            }
        }
    }
}