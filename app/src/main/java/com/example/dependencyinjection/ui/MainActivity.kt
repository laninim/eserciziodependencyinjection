package com.example.dependencyinjection.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.dependencyinjection.ApplicationContainer


import com.example.dependencyinjection.R
import com.example.dependencyinjection.ui.factory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var display : ImageView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
        button = findViewById(R.id.button)
        val viewmodelFactory = MainViewModelFactory((application as ApplicationContainer).dogProvider)
        mainViewModel = ViewModelProvider(this,viewmodelFactory).get(MainViewModel::class.java)

        mainViewModel.randomDog.observe(this){
            display.load(it.message)
        }


    }

    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            mainViewModel.loadRandomDog()
        }
    }

    override fun onResume() {
        super.onResume()

    }
}