package com.navigation.drawer

import android.app.Application
import com.scaffold.di.initKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}