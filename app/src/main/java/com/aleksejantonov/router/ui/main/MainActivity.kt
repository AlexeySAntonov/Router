package com.aleksejantonov.router.ui.main

import android.os.Bundle
import com.aleksejantonov.router.*
import com.aleksejantonov.router.R.layout
import com.aleksejantonov.router.di.*
import com.aleksejantonov.router.util.navigation.*
import com.arellomobile.mvp.*
import com.arellomobile.mvp.presenter.*
import javax.inject.*

class MainActivity : MvpAppCompatActivity(), MainView {

  @Inject
  lateinit var router: AppRouter

  @Inject
  @InjectPresenter
  lateinit var presenter: MainPresenter

  @ProvidePresenter
  fun providePresenter(): MainPresenter = presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    DI.componentManager().mainScreenComponent().inject(this)
    router.createNavigator(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (savedInstanceState == null) router.openMain()
  }

  override fun onBackPressed() = router.back()
}
