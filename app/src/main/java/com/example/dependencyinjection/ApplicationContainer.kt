package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.network.NetworkProvider

class ApplicationContainer : Application() {

    val dogProvider = NetworkProvider().provide()
}