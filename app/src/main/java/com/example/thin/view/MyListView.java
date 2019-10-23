package com.example.thin.view;

import android.content.Context;
import android.widget.ListView;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
