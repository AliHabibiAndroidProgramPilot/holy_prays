package com.ali.holyprays.mvp.ext

import android.content.Context
import android.content.Intent
import android.view.Window

interface ActivityUtils {
    fun takeWindow(): Window? { return null }
    fun takeContext(): Context
    fun startAnotherActivity(intent: Intent) {}
}