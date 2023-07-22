package com.example.lib.api

import android.view.View

import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2


class Page3Change : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        if (position < -1 || position > 1) {
            page.alpha = 1f
            page.translationX = 0f
            page.rotationY = 0f
        } else {
            if (-1 <= position && position < 0) {
                page.alpha = 1 + position
                page.translationX = -position * page.width
                page.rotationY = 180 * position
            } else if (0 < position && position <= 1) {
                page.alpha = 1 - position
                page.translationX = -position * page.width
                page.rotationY = 180 * position
            } else {
                page.alpha = 1f
                page.translationX = 0f
                page.rotationY = 0f
            }
        }
    }
}