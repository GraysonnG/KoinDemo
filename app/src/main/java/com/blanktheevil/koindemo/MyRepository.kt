package com.blanktheevil.koindemo

import com.blanktheevil.koindemo.api.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MyRepository {
    suspend fun getApiData(): String
}

class MyRepositoryImpl(
    private val myApi: MyApi,
) : MyRepository {
    override suspend fun getApiData(): String = withContext(Dispatchers.IO) {
        return@withContext myApi.getData().data
    }
}