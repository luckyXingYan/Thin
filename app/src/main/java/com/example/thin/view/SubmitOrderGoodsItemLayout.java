package com.example.thin.view;

import android.content.Context;

import com.example.thin.R;
import com.example.thin.bean.GoodBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class SubmitOrderGoodsItemLayout extends BaseLayout<GoodBean> {

    public SubmitOrderGoodsItemLayout(Context context) {
        super(context);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_submit_order_goods, this);

    }

    @Override
    public void setData(GoodBean data) {


    }


}
