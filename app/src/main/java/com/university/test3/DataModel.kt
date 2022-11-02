package com.university.test3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val str: MutableLiveData<String> by lazy  {
        MutableLiveData<String>()
    }
}