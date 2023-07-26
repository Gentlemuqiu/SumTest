package com.example.lib.api

import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2


class Page2Change() : ViewPager2.PageTransformer {
    private val SCALE_VALUE = 1f

    //旋转
    private val ROTATION = 60f

    override fun transformPage(view: View, position: Float) {


        //隐藏左侧侧的view
        if (position == -1f) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }

        //当前view
        if (position == 0f) {
            view.scaleX = SCALE_VALUE
            view.scaleY = SCALE_VALUE
        } else {
            //左侧已经隐藏了，所以这里值的是右侧View的偏移量
            val scaleFactor = Math.min(SCALE_VALUE - position * 0.1f, SCALE_VALUE)
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


