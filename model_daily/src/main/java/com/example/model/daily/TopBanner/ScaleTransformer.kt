package com.example.model.daily.TopBanner

import android.view.View
import androidx.viewpager2.widget.ViewPager2

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/20 10:28
 */
class ScaleTransformer:ViewPager2.PageTransformer {

    companion object {
        private const val MAX_SCALE = 1.0f //0缩放
        private const val MIN_SCALE = 0.80f //0.85缩放
    }

    override fun transformPage(page: View, position: Float) {
        if (position < 1) {
                val scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE)
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
            } else {
                page.scaleX = MIN_SCALE
                page.scaleY = MIN_SCALE
            }
        }
    }