package com.example.giphlab.di

import com.example.giphlab.BuildConfig
import com.example.giphlab.Constants
import com.example.giphlab.data.remote.NetworkDataSource
import com.example.giphlab.data.remote.RequestInterceptor
import com.example.giphlab.data.remote.WebService
import com.example.giphlab.domain.GiphLabRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): WebService {

        val gson = GsonBuilder().setLenient().create()

        val httpLogger = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(httpLogger)
            .build()


        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(WebService::class.java)
    }

    @Provides
    fun provideRepository(networkDataSource: NetworkDataSource) =
        GiphLabRepository(networkDataSource)
}