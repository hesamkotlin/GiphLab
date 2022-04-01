package com.example.giphlab.domain

import com.example.giphlab.data.model.GiphLab
import com.example.giphlab.shared.model.GifModel

fun List<GiphLab>.mapToGifModel(): List<GifModel>{
    return map {
        GifModel(
            id= it.id,
            title = it.title,
            imageUrl = it.images.preview?.imageUrl
        )
    }
}