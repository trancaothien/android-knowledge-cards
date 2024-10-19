package com.studio35.knowledgecards.domain.usecases

import com.studio35.knowledgecards.domain.models.Model
import com.studio35.knowledgecards.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<List<Model>> {
        return repository.getModels()
    }
}