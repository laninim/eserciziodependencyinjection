package com.example.dependencyinjection.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjection.network.DogService

class MainViewModelFactory(val dogService: DogService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DogService::class.java).newInstance(dogService)
    }
}