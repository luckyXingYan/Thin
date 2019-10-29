package com.example.thin.view;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.bean.CartGoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartGoodsView extends BaseHomeLayout<CartGoodsBean> implements View.OnClickListener {
    private LinearLayout item;
    private CartGoodsBean data;
    private CheckBox checkBox;

    public CartGoodsView(Context context) {
        super(context);
        data = new CartGoodsBean();
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_cart_goods, this);
        item = findViewById(R.id.ll_item_shop_cart_goods);
        checkBox = findViewById(R.id.cb_cart_shop);
        item.setOnClickListener(this);
    }

    @Override
    public void setData(CartGoodsBean data) {
        this.data = data;
        checkBox.setChecked(data.isSelect);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_item_shop_cart_goods://购物车物品
                if (!data.isSelect) {
                    data.isSelect = true;
                } else {
                    data.isSelect = false;
                }
                setData(data);
                break;
            default:
                break;
        }
    }
}
