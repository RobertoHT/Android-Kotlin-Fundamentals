package com.example.android.dessertclicker

import android.app.Application
import timber.log.Timber

/**
 * Created by Roberto Hdez on 2020-02-12
 */

class ClickerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}