package com.blanktheevil.koindemo.di

import com.blanktheevil.koindemo.MyRepository
import com.blanktheevil.koindemo.MyRepositoryImpl
import com.blanktheevil.koindemo.api.MyApi
import com.blanktheevil.koindemo.viewmodel.KoinDemoViewModel
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

private const val API_URL = "https://blanktheevil.com"

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder().build()
    }

    single<Moshi> {
        Moshi.Builder().build()
    }

    single<MyApi> {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
            .build()
            .create()
    }

    factory<MyRepository> {
        MyRepositoryImpl(
            myApi = get()
        )
    }


    viewModelOf(::KoinDemoViewModel)
}