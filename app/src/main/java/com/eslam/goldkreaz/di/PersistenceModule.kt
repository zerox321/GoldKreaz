
package com.eslam.goldkreaz.di

import androidx.room.Room
import com.eslam.entity.database.AppDatabase
import com.eslam.goldkreaz.R
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {
  single {
    Room
      .databaseBuilder(androidApplication(), AppDatabase::class.java,
        androidApplication().getString(R.string.database))
      .allowMainThreadQueries()
      .fallbackToDestructiveMigration()
      .build()
  }

  single { get<AppDatabase>().categoryDao() }
}
