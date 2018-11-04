package com.aleksejantonov.router.ui.base

import com.arellomobile.mvp.*
import com.jakewharton.rxrelay2.*
import io.reactivex.disposables.*

abstract class BasePresenter<V : MvpView> : MvpPresenter<V>() {
    private val disposables = CompositeDisposable()
    private val disposablesUntilDetach = CompositeDisposable()
    val viewActions = PublishRelay.create<Any>()

    fun viewAction(action: Any) {
        viewActions.accept(action)
    }

    protected fun Disposable.keepUntilDestroy() {
        disposables.add(this)
    }

    protected fun Disposable.keepUntilDetach() {
        disposablesUntilDetach.add(this)
    }

    override fun detachView(view: V) {
        disposablesUntilDetach.clear()
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}