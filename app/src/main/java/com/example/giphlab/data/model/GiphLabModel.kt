package com.example.giphlab.data.model

import com.google.gson.annotations.SerializedName

data class GiphLabModel(

    @field:SerializedName("data")
    val response: List<GiphLab>,
)

data class GiphLab(

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String?,

    @field:SerializedName("images")
    val images: ImageModel,
)

data class ImageModel(

    @field:SerializedName("preview_gif")
    val preview: Preview?,
)

data class Preview(

    @field:SerializedName("url")
    val imageUrl: String?,
)