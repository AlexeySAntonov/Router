package com.aleksejantonov.router.di.component

import com.aleksejantonov.router.di.module.*
import com.aleksejantonov.router.di.scope.*
import com.aleksejantonov.router.ui.start.*
import dagger.*

@StartScreenScope
@Subcomponent(modules = arrayOf(StartScreenModule::class))
interface StartScreenComponent {
  fun inject(startFragment: StartFragment)
}