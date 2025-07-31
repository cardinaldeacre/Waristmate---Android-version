package com.example.waristmate.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Bab(
    val id: Int,
    @StringRes val titleResId: Int,
    val route: String,
    @DrawableRes val imageResId: Int
)