package com.example.giphlab.data.model
import com.google.gson.annotations.SerializedName

data class Preview(

    @field:SerializedName("url")
    val imageUrl: String?,
)