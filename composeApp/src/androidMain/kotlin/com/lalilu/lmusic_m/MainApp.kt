package com.lalilu.lmusic_m

import android.app.Application
import com.lalilu.ldownloader.initKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}