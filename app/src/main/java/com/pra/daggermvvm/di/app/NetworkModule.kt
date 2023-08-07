package com.pra.daggermvvm.di.app

import com.pra.daggermvvm.api.WebApi
import com.pra.daggermvvm.di.app.ApplicationScope
import com.pra.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {


    @ApplicationScope
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
    }

    @ApplicationScope
    @Provides
    fun provideWebApi(retrofit: Retrofit): WebApi {
        return retrofit.create(WebApi::class.java)
    }

    @ApplicationScope
    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

}