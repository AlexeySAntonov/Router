package com.aleksejantonov.router.di.module

import com.aleksejantonov.router.di.scope.StartScreenScope
import com.aleksejantonov.router.ui.start.StartPresenter
import com.aleksejantonov.router.util.navigation.AppRouter
import dagger.Module
import dagger.Provides

@Module
class StartScreenModule {

  @Provides
  @StartScreenScope
  fun provideStartScreenPresenter(router: AppRouter) = StartPresenter(router)
}