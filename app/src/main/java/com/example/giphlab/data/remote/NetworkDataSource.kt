package com.example.giphlab.data.remote

import com.example.giphlab.Constants
import com.example.giphlab.domain.mapToGifModel
import com.example.giphlab.shared.model.GifModel
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val webService: WebService
) {

    suspend fun getTrends(): Resource<List<GifModel>> {
        return Resource.Success(webService.getTrends(Constants.API_KEY).response.mapToGifModel())
    }
}