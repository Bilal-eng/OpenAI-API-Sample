package com.example.openaiapisample.api


import com.example.openaiapisample.model.GeneratedAnswer
import com.example.openaiapisample.model.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("completions")
    suspend fun getPrompt(@Body body: RequestBody): GeneratedAnswer
}