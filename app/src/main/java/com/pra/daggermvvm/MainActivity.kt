package com.pra.daggermvvm

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.pra.daggermvvm.api.WebApi
import com.pra.daggermvvm.api.WebApiClient
import com.pra.daggermvvm.model.Products
import com.pra.daggermvvm.viewmodel.MainViewModel
import com.pra.daggermvvm.viewmodel.factory.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    @Inject
    lateinit var webApi:WebApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      //  UserApplication.getInstance().appComponennt.inject(this)
        (application as UserApplication).appComponennt.inject(this)


        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.productLiveData.observe(this, Observer {
            val product = it
            for(i in product.indices){
                println("Product name => "+product[i].title)
            }
        })


      //  val response: Response<List<Products>> = WebApiClient(this).getWebapi().getProducts()
       /* response.enqueue(object : Callback<List<Products>> {
            override fun onResponse(
                call: Call<List<Products>>, response: Response<List<Products>>
            ) {
                when {
                    response.isSuccessful && response.body()!=null -> {
                        val mProduct = response.body()

                        for (item in mProduct!!){
                            println("Item name ---> "+item.title)
                        }

                    }
                    response.errorBody() != null -> {

                    }
                }
            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {

            }
        })*/
    }

}