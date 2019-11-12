package com.example.thin.view;

import android.content.Context;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.ShopBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailInfo extends BaseHomeLayout<GoodsBean> {
    private TextView content;

    public MallDetailInfo(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_mall_detail_info, this);
        content = findViewById(R.id.tv_content);
    }

    @Override
    public void setData(GoodsBean data) {
        content.setText(data.content);
    }
}
