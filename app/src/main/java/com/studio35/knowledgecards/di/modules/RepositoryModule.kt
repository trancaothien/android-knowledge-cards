package com.studio35.knowledgecards.di.modules

import com.studio35.data.remote.services.ApiService
import com.studio35.data.repositories.RepositoryImpl
import com.studio35.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)
}
