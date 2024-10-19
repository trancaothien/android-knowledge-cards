package com.studio35.knowledgecards.di.modules

import android.content.Context
import com.studio35.knowledgecards.data.local.preferences.EncryptedSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    companion object {

        @Provides
        fun provideSecuredLocalStorage(@ApplicationContext context: Context) =
            EncryptedSharedPreferences(context)
    }
}
