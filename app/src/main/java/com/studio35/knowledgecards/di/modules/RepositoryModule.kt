package com.studio35.knowledgecards.di.modules

import com.studio35.knowledgecards.data.remote.services.ApiService
import com.studio35.knowledgecards.data.repositories.RepositoryImpl
import com.studio35.knowledgecards.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)
}
