package com.example.openaiapisample.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "https://api.openai.com/v1/"
    private val token =
        "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"

    private var client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest: Request =
            chain.request().newBuilder().addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer $token").build()
        chain.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideApiService(): ApiService = Retrofit.Builder().client(client).baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

}