package com.example.thin.view;

import android.content.Context;

import com.example.thin.R;
import com.example.thin.bean.CartShopBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartShopView extends BaseHomeLayout<CartShopBean> {
    public CartShopView(Context context) {
        super(context);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_cart_shop,this);

    }

    @Override
    public void setData(CartShopBean data) {

    }
}
