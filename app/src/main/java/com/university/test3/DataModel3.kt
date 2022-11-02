package com.university.test3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel3: ViewModel() {
    val tracklist: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}