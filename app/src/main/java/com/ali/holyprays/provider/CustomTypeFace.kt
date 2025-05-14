package com.ali.holyprays.provider

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.MetricAffectingSpan

class CustomTypeFace(private val customTypeface: Typeface) : MetricAffectingSpan() {

    private fun applyCustomTypeface(paint: Paint, typeface: Typeface) {
        val oldTypeface = paint.typeface
        val oldStyle = oldTypeface?.style ?: 0
        val fakeStyle = oldStyle and typeface.style.inv()
        if (fakeStyle and Typeface.BOLD != 0)
            paint.isFakeBoldText = true
        if (fakeStyle and Typeface.ITALIC != 0)
            paint.textSkewX = -0.25f
        paint.typeface = typeface
    }

    override fun updateDrawState(paint: TextPaint) {
        applyCustomTypeface(paint, customTypeface)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeface(paint, customTypeface)
    }

}