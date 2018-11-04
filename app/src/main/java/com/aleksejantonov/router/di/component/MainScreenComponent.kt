package com.aleksejantonov.router.di.component

import com.aleksejantonov.router.di.module.*
import com.aleksejantonov.router.di.scope.*
import com.aleksejantonov.router.ui.main.*
import dagger.*

@MainScreenScope
@Subcomponent(modules = arrayOf(MainScreenModule::class))
interface MainScreenComponent {
    fun inject(mainActivity: MainActivity)
}