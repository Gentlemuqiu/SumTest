package com.example.model.daily

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText


/*
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/19 19:51
 */

class SuperEditText : AppCompatEditText {
    //定义两张图
    private var clearDrawable: Drawable? = null
    private var searchDrawable: Drawable? = null

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
        init()
    }

    //初始化
    private fun init() {
        clearDrawable = resources.getDrawable(R.drawable.cancel)
        searchDrawable = resources.getDrawable(R.drawable.search)
        setCompoundDrawablesWithIntrinsicBounds(searchDrawable, null, null, null)
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        setClearIconVisible(focused && length() > 0)
    }

    private fun setClearIconVisible(visible: Boolean) {
        setCompoundDrawablesWithIntrinsicBounds(
            searchDrawable,
            null,
            if (visible) clearDrawable else null,
            null
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_UP -> {
                val drawable = clearDrawable
                if (drawable != null && event.x <= width - paddingRight && event.x >= width - paddingRight- drawable.bounds.width()) {
                    setText("")
                }
            }
        }
        return super.onTouchEvent(event)
    }
}