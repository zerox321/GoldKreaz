
package com.eslam.goldkreaz

import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.eslam.goldkreaz.di.networkModule
import com.eslam.goldkreaz.di.persistenceModule
import com.eslam.goldkreaz.di.repositoryModule
import com.eslam.goldkreaz.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@Suppress("unused")
class App : MultiDexApplication() {

  override fun onCreate() {
    super.onCreate()
    AndroidThreeTen.init(this)

    startKoin {
      androidContext(this@App)

      modules(networkModule)

      modules(persistenceModule)

      modules(repositoryModule)

      modules(viewModelModule)
    }

//    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
//    }
  }
}
