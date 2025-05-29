package com.ali.holyprays

import android.app.Application
import com.ali.holyprays.mvp.ext.PrefsManager

class MyApplication : Application() {

    override fun onCreate() {
        PrefsManager.init(this)
        super.onCreate()
    }

}