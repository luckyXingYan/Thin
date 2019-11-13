package com.example.thin.view;

import android.content.Context;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.MyOrderActivity;
import com.example.thin.bean.ShopTempBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class OrderShopLayout extends BaseLayout<ShopTempBean> {
    private TextView sendType;

    public OrderShopLayout(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_shop, this);
        sendType = findViewById(R.id.tv_send_type);

        if (getContext() instanceof MyOrderActivity) {
            sendType.setVisibility(VISIBLE);
        }
    }

    @Override
    public void setData(ShopTempBean data) {

    }
}
