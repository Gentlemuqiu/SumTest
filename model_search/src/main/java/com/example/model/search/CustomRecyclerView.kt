package com.example.model.search

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.abs

class CustomRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    private var startX: Float = 0f
    private var startY: Float = 0f

    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = e.x
                startY = e.y
                parent.requestDisallowInterceptTouchEvent(true) // 禁止父布局拦截触摸事件
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = abs(e.x - startX)
                val dy = abs(e.y - startY)
                if (dx > dy) {
                    parent.requestDisallowInterceptTouchEvent(true)
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        return super.onInterceptTouchEvent(e)
    }
}
