package com.example.thin.view;

import android.content.Context;

import com.example.thin.R;
import com.example.thin.bean.CartGoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class TakeOederGoodsView extends BaseHomeLayout<CartGoodsBean> {

    public TakeOederGoodsView(Context context) {
        super(context);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_take_order_goods, this);
//        swipeRevealLayout = findViewById(R.id.swipe_reveal_layout);

    }

    @Override
    public void setData(CartGoodsBean data) {


    }


}
