package com.ali.holyprays.mvp.ext

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.Window
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

interface ActivityUtils {
    fun takeWindow(): Window? { return null }
    fun takeContext(): Context
    fun takeLifecycleOwner(): LifecycleOwner? { return null }
    fun takeFragmentManager(): FragmentManager? { return null }
    fun takeBackPressedDispatchers(): OnBackPressedDispatcher? { return null }
    fun takeActivityIntentExtra(): Intent? { return null }
    fun takeActivityResources(): Resources? { return null }
    fun takeFinishActivity() {}
}