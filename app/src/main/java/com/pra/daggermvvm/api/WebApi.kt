package com.pra.daggermvvm.api

import com.pra.daggermvvm.model.Products
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WebApi {

    @GET("products")
    suspend fun getProducts(): Response<List<Products>>

}