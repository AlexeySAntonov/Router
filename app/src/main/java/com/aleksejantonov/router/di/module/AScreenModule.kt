package com.aleksejantonov.router.di.module

import com.aleksejantonov.router.di.scope.AScreenScope
import com.aleksejantonov.router.ui.a.APresenter
import com.aleksejantonov.router.util.navigation.AppRouter
import dagger.Module
import dagger.Provides

@Module
class AScreenModule {

  @Provides
  @AScreenScope
  fun provideAScreenPresenter(router: AppRouter) = APresenter(router)
}