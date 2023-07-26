package com.example.model.daily.CustomView

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/26 01:18
 */
import android.view.View

import androidx.viewpager2.widget.ViewPager2

class ArcUpTransformer : ViewPager2.PageTransformer {

    private val DEF_MAX_ROT = 12.0f
    private var mMaxRotate = DEF_MAX_ROT

    override fun transformPage(page: View, position: Float) {
        page.pivotY = 0f
        when {
            position < -1f -> { // [-Infinity, -1)
                page.rotation = mMaxRotate
                page.pivotX = page.width.toFloat()
            }
            position <= 1f -> { // [-1, 1]
                if (position < 0f) { // [-1, 0)
                    page.rotation = -mMaxRotate * position
                    page.pivotX = page.width * (0.5f - 0.5f * position)
                } else { // [0, 1]
                    page.rotation = -mMaxRotate * position
                    page.pivotX = page.width * (0.5f - 0.5f * position)
                }
            }
            else -> { // (1, +Infinity]
                page.rotation = -mMaxRotate
                page.pivotX = 0f
            }
        }
    }
}