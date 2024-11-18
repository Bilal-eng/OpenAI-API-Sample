package com.example.openaiapisample.ui.repository

import com.example.openaiapisample.api.ApiService
import com.example.openaiapisample.model.GeneratedAnswer
import com.example.openaiapisample.model.RequestBody
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPrompt(message: RequestBody): GeneratedAnswer {
        return apiService.getPrompt(message)
    }
}