package com.aleksejantonov.router

import android.app.*
import com.aleksejantonov.router.di.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DI.init(this)
    }
}