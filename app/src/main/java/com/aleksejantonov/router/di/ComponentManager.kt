package com.aleksejantonov.router.di

import android.content.*
import com.aleksejantonov.router.di.component.*
import com.aleksejantonov.router.di.module.*

class ComponentManager(context: Context) {
  private val appComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
        .appModule(AppModule(context))
        .build()
  }

  private var mainScreenComponent: MainScreenComponent? = null
  private var startScreenComponent: StartScreenComponent? = null
  private var aScreenComponent: AScreenComponent? = null

  fun mainScreenComponent(): MainScreenComponent {
    if (mainScreenComponent == null) mainScreenComponent = appComponent.addMainScreenComponent(MainScreenModule())
    return requireNotNull(mainScreenComponent)
  }

  fun releaseMainScreenComponent() {
    mainScreenComponent = null
  }

  fun startScreenComponent(): StartScreenComponent {
    if (startScreenComponent == null) startScreenComponent = appComponent.addStartScreenComponent(StartScreenModule())
    return requireNotNull(startScreenComponent)
  }

  fun releaseStartScreenComponent() {
    startScreenComponent = null
  }

  fun aScreenComponent(): AScreenComponent {
    if (aScreenComponent == null) aScreenComponent = appComponent.addAScreenComponent(AScreenModule())
    return requireNotNull(aScreenComponent)
  }

  fun releaseAScreenComponent() {
    aScreenComponent = null
  }
}