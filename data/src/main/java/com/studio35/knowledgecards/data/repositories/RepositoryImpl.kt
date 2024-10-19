package com.studio35.knowledgecards.data.repositories

import com.studio35.knowledgecards.data.extensions.flowTransform
import com.studio35.knowledgecards.data.remote.models.responses.toModels
import com.studio35.knowledgecards.data.remote.services.ApiService
import com.studio35.knowledgecards.domain.models.Model
import com.studio35.knowledgecards.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {

    override fun getModels(): Flow<List<Model>> = flowTransform {
        apiService.getResponses().toModels()
    }
}
