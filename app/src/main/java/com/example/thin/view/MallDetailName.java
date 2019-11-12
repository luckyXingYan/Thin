package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.ShopDetailActivity;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.ShopBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailName extends BaseHomeLayout<GoodsBean> implements View.OnClickListener {
    private RelativeLayout shopDetail;
    private TextView proName, price, sales, freight;
    private String shopId;

    public MallDetailName(Context context) {
        this(context, null);
    }

    public MallDetailName(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {

        inflate(getContext(), R.layout.layout_mall_detail_name, this);
        shopDetail = findViewById(R.id.rl_shop_detail);
        proName = findViewById(R.id.tv_shop_name);
        price = findViewById(R.id.tv_price);
        sales = findViewById(R.id.tv_sale_num);
        freight = findViewById(R.id.tv_freight);
        shopDetail.setOnClickListener(this);

    }

    @Override
    public void setData(GoodsBean data) {
        shopId = data.shopId;
        proName.setText(data.productName);
        price.setText(data.productPrice);
        sales.setText("销量  " + data.sales);
        freight.setText("运费  " + data.freight);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_shop_detail://店铺详情
                ShopDetailActivity.open(getContext(), shopId);
                break;
            default:
                break;
        }
    }
}
