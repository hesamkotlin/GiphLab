package com.example.giphlab.data.model
import com.google.gson.annotations.SerializedName

data class ImageModel(
    @field:SerializedName("preview_gif")
    val preview: Preview?,
)