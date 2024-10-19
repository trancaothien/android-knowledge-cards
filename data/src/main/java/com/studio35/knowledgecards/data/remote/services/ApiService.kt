package com.studio35.knowledgecards.data.remote.services

import com.studio35.knowledgecards.data.remote.models.responses.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getResponses(): List<Response>
}
