package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;

import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class HomeFootView extends BaseHomeLayout {

    public HomeFootView(Context context) {
        this(context, null);
    }

    public HomeFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_home_foot, this);
    }

    @Override
    public void setData(Object data) {

    }

}
