package com.aleksejantonov.router.di.module

import com.aleksejantonov.router.di.scope.*
import com.aleksejantonov.router.ui.main.*
import dagger.*

@Module
class MainScreenModule {

  @Provides
  @MainScreenScope
  fun provideMainPresenter() = MainPresenter()

}