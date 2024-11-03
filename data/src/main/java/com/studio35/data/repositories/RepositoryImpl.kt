package com.studio35.data.repositories

import com.studio35.data.extensions.flowTransform
import com.studio35.data.remote.models.responses.toModels
import com.studio35.data.remote.services.ApiService
import com.studio35.domain.models.Model
import com.studio35.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {

    override fun getModels(): Flow<List<Model>> = flowTransform {
        apiService.getResponses().toModels()
    }
}
