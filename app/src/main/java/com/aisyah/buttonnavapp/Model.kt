package com.aisyah.buttonnavapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model (
    var name: String,
    var desc: String,
    var photo: Int
) : Parcelable