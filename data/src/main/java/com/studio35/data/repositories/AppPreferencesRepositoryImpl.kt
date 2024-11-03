package com.studio35.data.repositories

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.studio35.domain.repositories.AppPreferencesRepository
import kotlinx.coroutines.flow.*
import java.io.IOException
import javax.inject.Inject

class AppPreferencesRepositoryImpl @Inject constructor(
    private val appPreferencesDataStore: DataStore<Preferences>
) : AppPreferencesRepository {

    private object PreferencesKeys {
        val APP_PREFERENCE = booleanPreferencesKey("APP_PREFERENCE")
    }

    override fun getAppPreference(): Flow<Boolean> = appPreferencesDataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.i(
                    AppPreferencesRepositoryImpl::class.simpleName,
                    "Error reading preferences.",
                    exception
                )
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[PreferencesKeys.APP_PREFERENCE] ?: true
        }

    override suspend fun updateAppPreference(appPreferencesValue: Boolean) {
        appPreferencesDataStore.edit { preferences ->
            preferences[PreferencesKeys.APP_PREFERENCE] = appPreferencesValue
        }
    }
}
