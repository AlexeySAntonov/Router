package com.aleksejantonov.router.di

import android.content.*

object DI {
    private lateinit var componentManager: ComponentManager

    fun init(context: Context) {
        componentManager = ComponentManager(context)
    }

    fun componentManager() = componentManager
}