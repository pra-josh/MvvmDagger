package com.pra.daggermvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pra.daggermvvm.repository.MainRepository
import com.pra.daggermvvm.viewmodel.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: MainRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }


}