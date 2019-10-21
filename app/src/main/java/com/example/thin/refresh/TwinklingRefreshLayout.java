package com.example.thin.refresh;

import android.content.Context;
import android.util.AttributeSet;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * 作者： 钟雄辉
 * 时间： 2018/12/17
 * 描述：下拉刷新
 **/
public class TwinklingRefreshLayout extends SmartRefreshLayout {

    public TwinklingRefreshLayout(Context context) {
        this(context, null);
    }

    public TwinklingRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setRefreshHeader(new ClassicsHeader(context));
        setRefreshFooter(new ClassicsFooter(context));
    }
}