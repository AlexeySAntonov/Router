package com.aleksejantonov.router.ui.a

import com.aleksejantonov.router.di.DI
import com.aleksejantonov.router.ui.Screens.B_SCREEN
import com.aleksejantonov.router.ui.base.BasePresenter
import com.aleksejantonov.router.ui.base.BaseView.Action
import com.aleksejantonov.router.ui.base.BaseView.Action.OnNavigationClick
import com.aleksejantonov.router.util.navigation.AppRouter
import com.arellomobile.mvp.InjectViewState
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class APresenter @Inject constructor(
    private val router: AppRouter
) : BasePresenter<AView>() {

  override fun onFirstViewAttach() {
    viewActions
        .subscribeBy { handleAction(it as Action) }
  }

  private fun handleAction(action: Action) {
    when (action) {
      is OnNavigationClick -> router.forward(B_SCREEN)
    }
  }

  override fun onDestroy() {
    DI.componentManager().releaseAScreenComponent()
    super.onDestroy()
  }
}