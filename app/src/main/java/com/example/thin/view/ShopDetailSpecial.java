package com.example.thin.view;

import android.content.Context;

import com.example.thin.R;
import com.example.thin.bean.HotBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class ShopDetailSpecial extends BaseHomeLayout<HotBean> {
    public ShopDetailSpecial(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_shop_detail_special, this);
    }

    @Override
    public void setData(HotBean data) {

    }
}
