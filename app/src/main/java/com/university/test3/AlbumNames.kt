package com.university.test3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumNames(var cover: Int, var name: String, var trackList: ArrayList<String>) : Parcelable
