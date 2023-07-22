package com.example.lib.api

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class Page2Change(private val viewPager2: ViewPager2) : ViewPager2.PageTransformer {
    private val SCALE_VALUE = 1f

    //View 之间的偏移量
    private val DEVIATION = 60f

    //旋转
    private val ROTATION = 60f

    //将图片设置为不叠加
    private val isStack = false


    override fun transformPage(view: View, position: Float) {

        val pageWidth = viewPager2.width

        //隐藏左侧侧的view
        if (position == -1f) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }

        //当前View和右侧的View [让右侧View和当前View叠加起来]
        if (position >= 0) {
            val translationX: Float = if (isStack) {
                DEVIATION - pageWidth * position
            } else {
                (DEVIATION - pageWidth) * position
            }
            view.translationX = translationX
        }

        //当前view
        if (position == 0f) {
            view.scaleX = SCALE_VALUE
            view.scaleY = SCALE_VALUE
        } else {
            //左侧已经隐藏了，所以这里值的是右侧View的偏移量
            val scaleFactor = (SCALE_VALUE - position * 0.1f).coerceAtMost(SCALE_VALUE)
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
        }

        //向左滑动
        if (position < 0 && position > -1) {
            //旋转
            view.rotation = ROTATION * position
            view.alpha = 1 - Math.abs(position)
        } else {
            //透明度 其他状态不设置透明度
            view.alpha = 1f
        }

        //向右滑动
        if (position > 0 && position < 1) {
            view.rotation = 0f
        }
    }
}