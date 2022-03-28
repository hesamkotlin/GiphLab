package com.example.giphlab.data.remote

import com.example.giphlab.Constants
import com.example.giphlab.data.model.GiphLab
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val webService: WebService
) {

    suspend fun getTrends(): Resource<List<GiphLab>> {
        return Resource.Success(webService.getTrends(Constants.API_KEY).response)
    }
}