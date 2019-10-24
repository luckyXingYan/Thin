package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;

import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class OrderFootView extends BaseHomeLayout {

    public OrderFootView(Context context) {
        this(context, null);
    }

    public OrderFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_order_foot, this);
    }

    @Override
    public void setData(Object data) {

    }

}
