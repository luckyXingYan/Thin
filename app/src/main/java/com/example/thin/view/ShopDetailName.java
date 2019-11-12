package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.bean.ShopBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class ShopDetailName extends BaseHomeLayout<ShopBean> implements View.OnClickListener {

    private TextView shopName, address, telephone;

    public ShopDetailName(Context context) {
        this(context, null);
    }

    public ShopDetailName(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_shop_detail_name, this);
        shopName = findViewById(R.id.tv_shop_name);
        address = findViewById(R.id.tv_address);
        telephone = findViewById(R.id.tv_telephone);

    }

    @Override
    public void setData(ShopBean data) {
        shopName.setText(data.shopName);
        address.setText(data.address);
        telephone.setText(data.telephone);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.rl_shop_detail://店铺详情
//                ShopDetailActivity.open(getContext());
//                break;
            default:
                break;
        }
    }
}
