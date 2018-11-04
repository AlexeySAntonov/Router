package com.aleksejantonov.router.di.module

import android.content.*
import com.aleksejantonov.router.model.network.http.VkApi
import com.aleksejantonov.router.util.navigation.*
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.*

@Module
class AppModule(private val context: Context) {
  private companion object {
    const val BASE_URL = "https://api.vk.com"
  }

  @Provides
  @Singleton
  fun provideAppRouter() = AppRouter()

  @Provides
  @Singleton
  fun provideVkApi(): VkApi {
    val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(VkApi::class.java)
  }

}