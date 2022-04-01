package com.example.giphlab.domain

import com.example.giphlab.data.remote.NetworkDataSource
import com.example.giphlab.data.remote.Resource
import com.example.giphlab.shared.model.GifModel
import javax.inject.Inject

class GiphLabRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) {

    suspend fun getTrending(): Resource<List<GifModel>> {
        return networkDataSource.getTrends()
    }
}