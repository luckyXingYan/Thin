package com.example.thin.view;

import android.content.Context;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.bean.ShopBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopView extends BaseHomeLayout<ShopBean> {
    private int type;
    private TextView sendType;

    public ShopView(Context context, int type) {
        super(context);
        this.type = type;
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_shop, this);
        sendType = findViewById(R.id.tv_send_type);
        if (type == 1) {
            sendType.setVisibility(VISIBLE);
        }

    }

    @Override
    public void setData(ShopBean data) {

    }
}
