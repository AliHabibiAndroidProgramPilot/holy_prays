package com.ali.holyprays.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.holyprays.databinding.ActivityMainBinding
import com.ali.holyprays.mvp.ext.ActivityUtlis

class ViewMainActivity(
    context: Context,
    private val utils: ActivityUtlis
) {

    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}