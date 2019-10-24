package com.example.thin.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.activity.TakeOrderActivity;
import com.example.thin.base.util.ToastUtil;
import com.example.thin.bean.CartGoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartGoodsView extends BaseHomeLayout<CartGoodsBean> implements View.OnClickListener {
    private LinearLayout item;

    public CartGoodsView(Context context) {
        super(context);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_cart_goods, this);
        item = findViewById(R.id.ll_item_shop_cart_goods);
        item.setOnClickListener(this);
    }

    @Override
    public void setData(CartGoodsBean data) {


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_item_shop_cart_goods://购物车物品
                ToastUtil.showToastShort(getContext(), "onItemClick");
                break;
            default:
                break;
        }
    }
}
