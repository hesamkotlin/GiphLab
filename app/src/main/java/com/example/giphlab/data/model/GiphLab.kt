package com.example.giphlab.data.model
import com.google.gson.annotations.SerializedName

data class GiphLab(

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String?,

    @field:SerializedName("images")
    val images: ImageModel,
)