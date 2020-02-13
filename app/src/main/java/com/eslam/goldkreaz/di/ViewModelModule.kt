package com.eslam.goldkreaz.di

import com.eslam.goldkreaz.ui.main.home.HomeViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel
val viewModelModule = module {
  viewModel { HomeViewModel(get()) }
}
