package com.example.giphlab.data.remote

import com.example.giphlab.data.model.GiphLabModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("gifs/trending")
    suspend fun getTrends(
        @Query("api_key") key: String,
    ): GiphLabModel
}