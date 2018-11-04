package com.aleksejantonov.router.util.navigation

import android.support.v4.app.*
import com.aleksejantonov.router.*
import com.aleksejantonov.router.ui.*
import com.aleksejantonov.router.ui.Screens.A_SCREEN
import com.aleksejantonov.router.ui.Screens.B_SCREEN
import com.aleksejantonov.router.ui.Screens.MAIN_SCREEN
import com.aleksejantonov.router.ui.a.*
import com.aleksejantonov.router.ui.b.*
import com.aleksejantonov.router.ui.main.*
import com.aleksejantonov.router.ui.start.*
import com.aleksejantonov.router.util.navigation.MainNavigator.Commands.FORWARD
import com.aleksejantonov.router.util.navigation.MainNavigator.Commands.REPLACE

class MainNavigator(activity: MainActivity) {
    private val fragmentManager by lazy { activity.supportFragmentManager }

    fun openMain() {
        replace(MAIN_SCREEN)
    }

    fun replace(screen: Screens) {
        applyCommand(screen, REPLACE)
    }

    fun forward(screen: Screens) {
        applyCommand(screen, FORWARD)
    }

    fun back() {
        fragmentManager.popBackStackImmediate()
    }

    private fun applyCommand(screen: Screens, command: Commands, animate: Boolean = true) {
        fragmentManager
            .beginTransaction()
            .apply { if (animate) setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right) }
            .replace(R.id.fragmentContainer, getFragment(screen))
            .apply { if (command == FORWARD) addToBackStack(null) }
            .commitAllowingStateLoss()
    }

    private fun getFragment(screen: Screens): Fragment {
        return when (screen) {
            MAIN_SCREEN -> StartFragment.newInstance()
            A_SCREEN    -> AScreenFragment.newInstance()
            B_SCREEN    -> BScreenFragment.newInstance()
        }
    }

    enum class Commands {
        FORWARD,
        BACK,
        REPLACE
    }
}