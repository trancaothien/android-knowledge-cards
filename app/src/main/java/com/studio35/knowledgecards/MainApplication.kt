package com.studio35.knowledgecards

import android.app.Application
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupLogging()
        setupGoogleAdMob()
    }

    /**
     * Initialize Google AdMob
     */
    private fun setupGoogleAdMob() {
        MobileAds.initialize(this, {
            Timber.d("Google AdMob initialized: $it")
        })
    }

    /**
     * Initialize Logging
     */
    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
