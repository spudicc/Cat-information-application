package com.example.marinaspudic_iazmu.model

import android.media.Image

data class Item(
    var _id: Long?,
    val name: String,
    val origin: String,
    val imageLink: String,
    val maxLifeExpectancy: Int,
    val maxWeight: Int,
)
