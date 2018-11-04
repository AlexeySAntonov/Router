package com.aleksejantonov.router.util.navigation

import com.aleksejantonov.router.ui.*
import com.aleksejantonov.router.ui.main.*
import javax.inject.*

class AppRouter @Inject constructor() {
    private lateinit var navigator: MainNavigator

    fun createNavigator(activity: MainActivity) {
        navigator = MainNavigator(activity)
    }

    fun openMain() = navigator.openMain()
    fun replace(screen: Screens) = navigator.replace(screen)
    fun forward(screen: Screens) = navigator.forward(screen)
    fun back() = navigator.back()
}