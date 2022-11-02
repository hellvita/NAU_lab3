package com.university.test3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel2: ViewModel() {
    val img: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}