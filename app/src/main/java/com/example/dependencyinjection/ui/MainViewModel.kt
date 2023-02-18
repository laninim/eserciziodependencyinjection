package com.example.dependencyinjection.ui


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.model.Dog
import com.example.dependencyinjection.network.DogService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(val dogService: DogService) : ViewModel() {

    init {
        Log.d("ViewModel","View model created recreated")
    }

    private var _randomDog  = MutableLiveData<Dog>()
    val randomDog get() = _randomDog


    fun loadRandomDog() {
        CoroutineScope(Dispatchers.Main).launch {
            _randomDog.value = dogService.getRandomDog()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModel","ViewModel Destroy")
    }

}