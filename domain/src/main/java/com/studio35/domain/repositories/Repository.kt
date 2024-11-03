package com.studio35.domain.repositories

import com.studio35.domain.models.Model
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getModels(): Flow<List<Model>>
}
