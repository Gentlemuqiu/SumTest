package com.example.lib.api

import android.content.Context

class Utils {
    fun dip2px(context: Context, dpValue: Float): Int {
        // 获取当前手机的像素密度
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt() // 四舍五入取整
    }
    fun getScreenWidth(ctx: Context): Int {
        return ctx.resources.displayMetrics.widthPixels
    }
}