package com.aleksejantonov.router.di.component

import com.aleksejantonov.router.di.module.*
import dagger.*
import javax.inject.*

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun addMainScreenComponent(mainScreenModule: MainScreenModule): MainScreenComponent
  fun addStartScreenComponent(startScreenModule: StartScreenModule): StartScreenComponent
  fun addAScreenComponent(aScreenModule: AScreenModule): AScreenComponent
}