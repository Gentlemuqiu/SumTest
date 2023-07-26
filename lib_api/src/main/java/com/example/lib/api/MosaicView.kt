package com.example.lib.api

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

@SuppressLint("DrawAllocation")
class MosaicView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private val mPaint = Paint() // 声明一个画笔对象
    private var mGridCount = 20 // 格子的数量
    private var mMode = PorterDuff.Mode.DST_IN // 绘图模式为只展示交集
    private var mBitmap // 声明一个位图对象
            : Bitmap? = null
    private var mRatio = 0 // 绘制的比率
    private var mOffset = 5 // 偏差的比例
    private val FENMU = 100f // 计算比例的分母


    // 设置马赛克的格子数量
    fun setGridCount(grid_count: Int) {
        mGridCount = grid_count
    }

    // 设置偏差比例
    fun setOffset(offset: Int) {
        mOffset = offset
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

        val grid_width = (width / mGridCount).toFloat()
        val row_count = Math.ceil((height / grid_width).toDouble()).toInt()
        val total_count = mGridCount * row_count
        var draw_count = 0
        for (i in 0 until row_count) {
            for (j in 0 until mGridCount) {
                val now_ratio = ((mGridCount * i + j) * FENMU / total_count).toInt()
                if (now_ratio < mRatio - mOffset || (now_ratio >= mRatio - mOffset && now_ratio < mRatio
                            && ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1))) || (now_ratio >= mRatio && now_ratio < mRatio + mOffset && ((j % 2 == 0 && i % 2 == 1) || (j % 2 == 1 && i % 2 == 0)))
                ) {
                    val left = (grid_width * j).toInt()
                    val top = (grid_width * i).toInt()
                    // 在遮罩画布上绘制各方形格子
                    canvasMask.drawRect(
                        left.toFloat(),
                        top.toFloat(),
                        left + grid_width,
                        top + grid_width,
                        mPaint
                    )
                    if (j < mGridCount) {
                        draw_count++
                    }
                    if (draw_count * FENMU / total_count > mRatio) {
                        break
                    }
                }
            }
            if (draw_count * FENMU / total_count > mRatio) {
                break
            }
        }


        // 设置离屏缓存
        val saveLayer =
            canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        val rect = Rect(0, 0, width, width * mBitmap!!.height / mBitmap!!.width)
        canvas.drawBitmap(mBitmap!!, null, rect, mPaint) // 绘制目标图像
        mPaint.xfermode = PorterDuffXfermode(mMode) // 设置混合模式
        canvas.drawBitmap(mask, 0f, 0f, mPaint) // 再绘制源图像的遮罩
        mPaint.xfermode = null // 还原混合模式
        canvas.restoreToCount(saveLayer) // 还原画布
    }


}
