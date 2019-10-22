package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;

import com.example.thin.R;
import com.example.thin.bean.HomeDataBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailName extends BaseHomeLayout<HomeDataBean> {
    public MallDetailName(Context context) {
        this(context, null);
    }

    public MallDetailName(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_mall_detail_name, this);

    }

    @Override
    public void setData(HomeDataBean data) {

    }
}
