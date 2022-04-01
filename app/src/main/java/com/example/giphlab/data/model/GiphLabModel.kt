package com.example.giphlab.data.model

import com.google.gson.annotations.SerializedName

data class GiphLabModel(

    @field:SerializedName("data")
    val response: List<GiphLab>,
)