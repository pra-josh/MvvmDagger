package com.pra.daggermvvm.api

import android.content.Context
import com.pra.daggermvvm.model.Products
import com.pra.daggermvvm.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebApiClient(private val context: Context) {


    public fun getWebapi(): WebApi {
       // val cacheSize = (5 * 1024 * 1024).toLong()
       // val myCache = Cache(context.cacheDir, cacheSize)

        System.setProperty("http.keepAlive", "false")

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
      //  client.connectTimeoutMillis

        val retrofit =
            Retrofit.Builder().baseUrl(Constants.BaseUrl).addConverterFactory(GsonConverterFactory.create())
                .client(client).build()
        return retrofit.create(WebApi::class.java)
    }

   // fun getRandomUser(): Res<List<Products>> = getWebapi().getProducts()

}


