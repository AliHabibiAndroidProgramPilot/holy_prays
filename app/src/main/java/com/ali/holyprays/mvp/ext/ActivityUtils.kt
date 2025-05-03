package com.ali.holyprays.mvp.ext

import android.content.Context
import android.content.Intent
import android.view.Window
import androidx.activity.OnBackPressedDispatcher

interface ActivityUtils {
    fun takeWindow(): Window? { return null }
    fun takeContext(): Context
    fun startAnotherActivity(intent: Intent) {}
    fun takeBackPressedDispatchers(): OnBackPressedDispatcher? { return null }
    fun takeActivityIntentExtra(): Intent? { return null }
}