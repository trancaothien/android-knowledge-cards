package com.studio35.knowledgecards.domain.repositories

import com.studio35.knowledgecards.domain.models.Model
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getModels(): Flow<List<Model>>
}
