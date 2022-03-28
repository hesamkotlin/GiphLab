package com.example.giphlab.domain

import com.example.giphlab.data.model.GiphLab
import com.example.giphlab.data.remote.NetworkDataSource
import com.example.giphlab.data.remote.Resource
import javax.inject.Inject

class GiphLabRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) {

    suspend fun getTrending(): Resource<List<GiphLab>> {
        return networkDataSource.getTrends()
    }
}