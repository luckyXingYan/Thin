package com.example.thin.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author: xingyan
 * @Date: 2019/10/18
 * @Desc:
 */
public class DiffScreenPadding extends View {
    public DiffScreenPadding(Context context) {
        super(context);
        init();
    }

    public DiffScreenPadding(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DiffScreenPadding(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

}
