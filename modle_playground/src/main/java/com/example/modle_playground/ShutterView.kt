package com.example.modle_playground

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlin.math.ceil

@SuppressLint("DrawAllocation")
class ShutterView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private val mPaint = Paint() // 声明一个画笔对象
    private var mOriention = LinearLayout.HORIZONTAL // 动画方向
    private var mLeafCount = 10 // 叶片的数量
    private var mMode = PorterDuff.Mode.DST_IN // 绘图模式为只展示交集
    private var mBitmap // 声明一个位图对象
            : Bitmap? = null
    private var mRatio = 0 // 绘制的比率

    // 设置百叶窗的方向
    fun setOriention(oriention: Int) {
        mOriention = oriention
    }

    // 设置百叶窗的叶片数量
    fun setLeafCount(leaf_count: Int) {
        mLeafCount = leaf_count
    }

    // 设置绘图模式
    fun setMode(mode: PorterDuff.Mode) {
        mMode = mode
    }

    // 设置位图对象
    fun setImageBitmap(bitmap: Bitmap?) {
        mBitmap = bitmap
    }

    // 设置绘图比率
    fun setRatio(ratio: Int) {
        mRatio = ratio
        postInvalidate() // 立即刷新视图（线程安全方式）
    }


    override fun onDraw(canvas: Canvas) {
        if (mBitmap == null) {
            return
        }
        val width = measuredWidth // 获取视图的实际宽度
        val height = measuredHeight // 获取视图的实际高度
        // 创建一个遮罩位图
        val mask = Bitmap.createBitmap(width, height, mBitmap!!.config)
        val canvasMask = Canvas(mask) // 创建一个遮罩画布
        for (i in 0 until mLeafCount) {
            if (mOriention == LinearLayout.HORIZONTAL) { // 水平方向
                val column_width = ceil((width * 1f / mLeafCount).toDouble()).toInt()
                val left = column_width * i
                val right = left + column_width * mRatio / 100
                // 在遮罩画布上绘制各矩形叶片
                canvasMask.drawRect(
                    left.toFloat(),
                    0f,
                    right.toFloat(),
                    height.toFloat(),
                    mPaint
                )
            } else { // 垂直方向
                val row_height = Math.ceil((height * 1f / mLeafCount).toDouble()).toInt()
                val top = row_height * i
                val bottom = top + row_height * mRatio / 100
                // 在遮罩画布上绘制各矩形叶片
                canvasMask.drawRect(
                    0f,
                    top.toFloat(),
                    width.toFloat(),
                    bottom.toFloat(),
                    mPaint
                )
            }
        }
        // 设置离屏缓存
        val saveLayer = canvas.saveLayer(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            null,
            Canvas.ALL_SAVE_FLAG
        )
        val rect = Rect(0, 0, width, width * mBitmap!!.height / mBitmap!!.width)
        canvas.drawBitmap(mBitmap!!, null, rect, mPaint) // 绘制目标图像
        mPaint.xfermode = PorterDuffXfermode(mMode) // 设置混合模式
        canvas.drawBitmap(mask, 0f, 0f, mPaint) // 再绘制源图像的遮罩
        mPaint.xfermode = null // 还原混合模式
        canvas.restoreToCount(saveLayer) // 还原画布
    }


}
