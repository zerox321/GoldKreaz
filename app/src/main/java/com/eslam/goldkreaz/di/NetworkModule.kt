package com.eslam.goldkreaz.di

import com.eslam.network.EndPoint
import com.eslam.network.RequestInterceptor
import com.eslam.network.client.CategoryClient
import com.eslam.network.service.CategoryService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(EndPoint.KreazUrl)
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }




    single { get<Retrofit>().create(CategoryService::class.java) }

    single { CategoryClient(get()) }


}
