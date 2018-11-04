package com.aleksejantonov.router.ui.start

import com.aleksejantonov.router.di.DI
import com.aleksejantonov.router.ui.Screens.A_SCREEN
import com.aleksejantonov.router.ui.base.*
import com.aleksejantonov.router.ui.base.BaseView.Action
import com.aleksejantonov.router.ui.base.BaseView.Action.OnNavigationClick
import com.aleksejantonov.router.util.navigation.AppRouter
import com.arellomobile.mvp.*
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class StartPresenter @Inject constructor(
    private val router: AppRouter
) : BasePresenter<StartView>() {

  override fun onFirstViewAttach() {
    viewActions
        .subscribeBy { handleAction(it as Action) }
        .keepUntilDestroy()
  }

  private fun handleAction(action: Action) {
    when (action) {
      is OnNavigationClick -> router.forward(A_SCREEN)
    }
  }

  override fun onDestroy() {
    DI.componentManager().releaseStartScreenComponent()
    super.onDestroy()
  }
}