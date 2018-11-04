package com.aleksejantonov.router.di.component

import com.aleksejantonov.router.di.module.*
import com.aleksejantonov.router.di.scope.*
import com.aleksejantonov.router.ui.a.AScreenFragment
import com.aleksejantonov.router.ui.start.*
import dagger.*

@AScreenScope
@Subcomponent(modules = arrayOf(AScreenModule::class))
interface AScreenComponent {
  fun inject(aScreenFragment: AScreenFragment)
}