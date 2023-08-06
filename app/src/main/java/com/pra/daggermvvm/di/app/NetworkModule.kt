package com.pra.daggermvvm.di.app

import com.pra.daggermvvm.api.WebApi
import com.pra.daggermvvm.di.app.ApplicationScope
import com.pra.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {


    @ApplicationScope
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().
              baseUrl(Constants.BaseUrl).
              addConverterFactory(GsonConverterFactory.create())
                /*.client(client)*/.
              build()
    }

    @ApplicationScope
    @Provides
    fun provideWebApi(retrofit: Retrofit):WebApi{
        return retrofit.create(WebApi::class.java)
    }

}