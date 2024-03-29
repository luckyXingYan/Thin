package com.example.thin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class NoScrollVPLayout extends ViewPager {
    private boolean isHorizontalScroll;

    public NoScrollVPLayout(@NonNull Context context) {
        this(context, null);
    }

    public NoScrollVPLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.NoScrollVPLayout);
        //默认 viewPager 是横向滑动
        isHorizontalScroll = typedArray.getBoolean(R.styleable.NoScrollVPLayout_isHorizontalScroll, true);
    }

    /**
     * 动态代码设置 viewPager 是否可横向滑动
     * 也可在 xml 中设置 app:isHorizontalScroll="false"
     *
     * @param isScroll
     */
    public void setHorizontalScroll(boolean isScroll) {
        this.isHorizontalScroll = isScroll;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isHorizontalScroll) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isHorizontalScroll) {
            return super.onTouchEvent(ev);
        } else {
            return false;
        }
    }
}
