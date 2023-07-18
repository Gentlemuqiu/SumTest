package com.example.lib.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {
    private float initialY; // 记录初始Y坐标

    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 当手指按下时记录初始Y坐标
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            initialY = ev.getY();
        }

        // 判断当前滑动是否为上下滑动
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            float deltaY = ev.getY() - initialY;
            //getScaledTouchSlop()当大于这个距离时才会有滑动事件
            if (Math.abs(deltaY) > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                // 上下滑动，请求父级不要拦截事件
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        return super.dispatchTouchEvent(ev);
    }
}
