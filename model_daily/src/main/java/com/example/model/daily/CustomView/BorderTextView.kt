package com.example.model.daily.CustomView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 13:32
 */
class BorderTextView : AppCompatTextView {

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
    }

    private val sroke_width = 1
    override fun onDraw(canvas: Canvas) {
        val paint = Paint()
        //  将边框设为黑色
        paint.color = Color.BLACK
        //  画TextView的4个边
        canvas.drawLine(0f, 0f, (this.width - sroke_width).toFloat(), 0f, paint)
        canvas.drawLine(0f, 0f, 0f, (this.height - sroke_width).toFloat(), paint)
        canvas.drawLine(
            (this.width - sroke_width).toFloat(),
            0f,
            (this.width - sroke_width).toFloat(),
            (this.height - sroke_width).toFloat(),
            paint
        )
        canvas.drawLine(
            0f,
            (this.height - sroke_width).toFloat(),
            (this.width - sroke_width).toFloat(),
            (this.height - sroke_width).toFloat(),
            paint
        )
        super.onDraw(canvas)
    }

}