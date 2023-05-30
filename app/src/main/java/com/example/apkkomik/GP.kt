package com.example.apkkomik

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GP(
    val imgGp    :Int,
    val nama     :String,
    val belakang :String,
    val team     :String,
    val Deskripsi:String
):Parcelable