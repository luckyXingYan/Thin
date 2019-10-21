package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.thin.R;
import com.example.thin.adapter.HotAdapter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class FootView extends BaseHomeLayout {

    public FootView(Context context) {
        this(context, null);
    }

    public FootView(Context context, AttributeSet attrs) {
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
