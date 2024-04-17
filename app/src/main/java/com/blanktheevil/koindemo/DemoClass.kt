package com.blanktheevil.koindemo

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DemoClass(
    private val id: Int = 0,
    val name: String,
) : KoinComponent {
    private val myRepository by inject<MyRepository>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val data = myRepository.getApiData()
            Log.d("DemoClass", "Id: $id Data: $data")
        }
    }
}