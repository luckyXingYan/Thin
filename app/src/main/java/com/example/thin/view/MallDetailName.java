package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.thin.R;
import com.example.thin.activity.ShopDetailActivity;
import com.example.thin.bean.HotBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailName extends BaseHomeLayout<HotBean> implements View.OnClickListener {
    private RelativeLayout shopDetail;

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
        shopDetail.setOnClickListener(this);

    }

    @Override
    public void setData(HotBean data) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_shop_detail://店铺详情
                ShopDetailActivity.open(getContext());
                break;
            default:
                break;
        }
    }
}
