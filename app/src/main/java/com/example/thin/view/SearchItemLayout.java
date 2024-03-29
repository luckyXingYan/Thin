package com.example.thin.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class SearchItemLayout extends BaseLayout<String> {
    private int type;
    private TextView tvSearchTitle;
    private ImageView ivSearchHot;


    public SearchItemLayout(Context context, int type) {
        super(context);
        this.type = type;
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_search_title, this);
        tvSearchTitle = (TextView) findViewById(R.id.tv_search_title);
        ivSearchHot = (ImageView) findViewById(R.id.iv_search_hot);


    }

    @Override
    public void setData(String data) {
        if (type == 0) {
            ivSearchHot.setVisibility(GONE);
            tvSearchTitle.setText("最近搜索");
        } else if (type == 1) {
            ivSearchHot.setVisibility(VISIBLE);
            tvSearchTitle.setText("热门搜索");
        }
    }
}
