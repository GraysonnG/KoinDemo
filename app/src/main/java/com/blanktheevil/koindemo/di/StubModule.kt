package com.blanktheevil.koindemo.di

import com.blanktheevil.koindemo.MyRepository
import com.blanktheevil.koindemo.viewmodel.KoinDemoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val stubModule = module {
    viewModel {
        KoinDemoViewModel(
            myRepository = object : MyRepository {
                override suspend fun getApiData(): String {
                    return "Hello, World!"
                }
            }
        )
    }
}