package com.aleksejantonov.router.ui.base

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {

  sealed class Action {
    object OnNavigationClick : Action()
  }
}