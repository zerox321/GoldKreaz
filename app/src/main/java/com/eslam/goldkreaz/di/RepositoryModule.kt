package com.eslam.goldkreaz.di

import com.eslam.goldkreaz.repository.ClientRepository
import org.koin.dsl.module

val repositoryModule = module {


  single { ClientRepository(get(), get()) }


}
