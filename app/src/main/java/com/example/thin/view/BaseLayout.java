package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc: view的抽象类
 */
public abstract class BaseLayout<T> extends LinearLayout {
    public BaseLayout(Context context) {
        this(context, null);
    }

    public BaseLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected abstract void init();

    public abstract void setData(T data);
}
