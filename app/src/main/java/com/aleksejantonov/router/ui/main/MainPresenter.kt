package com.aleksejantonov.router.ui.main

import com.aleksejantonov.router.di.*
import com.aleksejantonov.router.ui.base.*
import com.arellomobile.mvp.*
import javax.inject.*

@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<MainView>() {

    override fun onDestroy() {
        DI.componentManager().releaseMainScreenComponent()
        super.onDestroy()
    }
}