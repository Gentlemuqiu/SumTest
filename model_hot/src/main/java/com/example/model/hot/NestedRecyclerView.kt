package com.example.model.hot

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.view.NestedScrollingChild2
import androidx.core.view.NestedScrollingChildHelper
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView


class NestedRecyclerView : RecyclerView, NestedScrollingChild2 {
    private var childHelper: NestedScrollingChildHelper? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        childHelper = NestedScrollingChildHelper(this)
        isNestedScrollingEnabled = true
    }

    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
        return super.onInterceptTouchEvent(e)
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        return super.onTouchEvent(e)
    }

    // Implement NestedScrollingChild2 methods
    override fun setNestedScrollingEnabled(enabled: Boolean) {
        childHelper!!.isNestedScrollingEnabled = enabled
    }

    override fun isNestedScrollingEnabled(): Boolean {
        return childHelper!!.isNestedScrollingEnabled
    }

    override fun startNestedScroll(axes: Int, type: Int): Boolean {
        return childHelper!!.startNestedScroll(axes, type)
    }

    override fun stopNestedScroll(type: Int) {
        childHelper!!.stopNestedScroll(type)
    }

    override fun hasNestedScrollingParent(type: Int): Boolean {
        return childHelper!!.hasNestedScrollingParent(type)
    }

    override fun dispatchNestedScroll(
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        offsetInWindow: IntArray?,
        type: Int
    ): Boolean {
        return childHelper!!.dispatchNestedScroll(
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            offsetInWindow,
            type
        )
    }

    override fun dispatchNestedPreScroll(
        dx: Int,
        dy: Int,
        consumed: IntArray?,
        offsetInWindow: IntArray?,
        type: Int
    ): Boolean {
        return childHelper!!.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)
    }

    override fun dispatchNestedFling(
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        return childHelper!!.dispatchNestedFling(velocityX, velocityY, consumed)
    }

    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float): Boolean {
        return childHelper!!.dispatchNestedPreFling(velocityX, velocityY)
    }

    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        return if (target is NestedRecyclerView) {
            // This method is called when a fling is about to happen in the nested scroll.
            // We want to check if the RecyclerView can scroll vertically in the nested direction.
            // If it can scroll, we don't perform the fling here and return true to indicate that
            // the child has consumed the fling. If it cannot scroll, we allow the parent to
            // perform the fling.
            !canScrollVertically(velocityY.toInt())
        } else false
    }
}
