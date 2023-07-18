package com.example.model.hot

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.NestedScrollingParent2
import androidx.viewpager2.widget.ViewPager2


class NestedParentView : LinearLayout, NestedScrollingParent2 {
    private var viewPager: ViewPager2? = null

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onFinishInflate() {
        super.onFinishInflate()
        viewPager = findViewById<ViewPager2>(com.example.model.hot.R.id.vp2_content) // 替换为实际的ViewPager2的ID
    }

    // Implement NestedScrollingParent2 methods
    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        return true
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {}
    override fun onStopNestedScroll(target: View, type: Int) {}
    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        // 当RecyclerView进行垂直滚动时，将滚动距离传递给ViewPager2进行水平滚动的处理
        if (target is NestedRecyclerView) {
            if (dy < 0 && !target.canScrollVertically(-1)) {
                viewPager!!.beginFakeDrag()
                viewPager!!.fakeDragBy(-dy.toFloat())
                viewPager!!.endFakeDrag()
                consumed[1] = dy
            }
        }
    }

    override fun onNestedFling(
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        // 如果RecyclerView无法进行垂直滚动，则传递fling事件给ViewPager2进行水平fling
        if (target is NestedRecyclerView) {
            if (!target.canScrollVertically(-1)) {
                viewPager!!.beginFakeDrag()
                viewPager!!.fakeDragBy(-velocityY / 1000) // 调整敏感度
                viewPager!!.endFakeDrag()
                return true
            }
        }
        return false
    }

    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        return false
    }

    override fun getNestedScrollAxes(): Int {
        return 0
    }
}
