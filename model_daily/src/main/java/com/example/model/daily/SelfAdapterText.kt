package com.example.model.daily

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/19 19:57
 */
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup


class SelfAdapterText : ViewGroup {
    //存储所有子View
    private val mAllChildViews: MutableList<MutableList<View>> = ArrayList()

    //记录行高
    private val mLineHeight: MutableList<Int> = ArrayList()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //父控件传入进来的宽度和高度以及对应的测量模式
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val modeWidth = MeasureSpec.getMode(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)
        val modeHeight = MeasureSpec.getMode(heightMeasureSpec)

        //当前ViewGroup的宽高为wrap_content
        //初始化自己测量的宽高度
        var width = 0
        var height = 0
        //记录每一行宽高度
        var lineWidth = 0
        var lineHeight = 0

        //获取子View的个数
        val childCount = childCount
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            //测量子View的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            //得到LayoutParams
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            if (lineWidth + childWidth > sizeWidth) {
                //得到本行的最大宽度
                width = Math.max(width, lineWidth)
                //重置行宽
                lineWidth = childWidth
                //记录行高
                height += lineHeight
                lineHeight = childHeight
            } else { //不换行
                //加宽加高
                lineWidth += childWidth
                lineHeight = Math.max(lineHeight, childHeight)
            }
            //处理到最后一个子View的情况
            if (i == childCount - 1) {
                width = Math.max(width, lineWidth)
                height += lineHeight
            }
        } //wrap_content
        setMeasuredDimension(
            if (modeWidth == MeasureSpec.EXACTLY) sizeWidth else width,
            if (modeHeight == MeasureSpec.EXACTLY) sizeHeight else height
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        mAllChildViews.clear()
        mLineHeight.clear()
        //获得当前ViewGroup宽度
        val width = width

        //初始化
        var lineWidth = 0
        var lineHeight = 0
        //记录当前行的view
        var lineViews: MutableList<View> = ArrayList()
        val childCount = childCount
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            //判断换行是否
            if (childWidth + lineWidth + lp.leftMargin + lp.rightMargin > width) {
                //记录高度
                mLineHeight.add(lineHeight)
                //记录当前行的View
                mAllChildViews.add(lineViews)
                //重置
                lineWidth = 0
                lineHeight = childHeight + lp.topMargin + lp.bottomMargin
                //重置当前行view
                lineViews = ArrayList()
            }
            lineWidth += childWidth + lp.rightMargin + lp.leftMargin
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin)
            lineViews.add(child)
        } //处理最后一行
        mLineHeight.add(lineHeight)
        mAllChildViews.add(lineViews)

        //设置子VIEW的位置
        var left = 0
        var top = 0
        //获得行数
        val lineCount = mAllChildViews.size
        for (i in 0 until lineCount) {
            //当前行的view和高度
            lineViews = mAllChildViews[i]
            lineHeight = mLineHeight[i]
            for (j in lineViews.indices) {
                val child = lineViews[j]
                //判断是否显示
                if (child.visibility == GONE) {
                    continue
                }
                val lp = child.layoutParams as MarginLayoutParams
                val cLeft = left + lp.leftMargin
                val cTop = top + lp.topMargin
                val cRight = cLeft + child.measuredWidth
                val cBottom = cTop + child.measuredHeight
                //进行布局
                child.layout(cLeft, cTop, cRight, cBottom)
                left += child.measuredWidth + lp.leftMargin + lp.rightMargin
            }
            //换行
            left = 0
            top += lineHeight
        }
    }

    /**
     * 与当前ViewGroup对应的LayoutParams
     */
    override fun generateLayoutParams(attrs: AttributeSet): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}