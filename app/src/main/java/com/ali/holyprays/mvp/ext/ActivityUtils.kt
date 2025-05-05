package com.ali.holyprays.mvp.ext

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.Window
import androidx.activity.OnBackPressedDispatcher

interface ActivityUtils {
    fun takeWindow(): Window? { return null }
    fun takeContext(): Context
    fun takeBackPressedDispatchers(): OnBackPressedDispatcher? { return null }
    fun takeActivityIntentExtra(): Intent? { return null }
    fun takeActivityResources(): Resources? { return null }
}