package com.example.thin.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.thin.R;
import com.example.thin.activity.SeeCouponCodeActivity;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class OrderBottomView extends BaseHomeLayout implements View.OnClickListener {
    private Button btnOne;
    private Button btnTwo;


    public OrderBottomView(Context context) {
        super(context);
    }


    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_order_bottom, this);

        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
    }

    @Override
    public void setData(Object data) {
//        if (position == 2) {//未使用
//            btnOne.setVisibility(GONE);
//            btnTwo.setText("查看券码");
//        } else {
//            btnOne.setVisibility(VISIBLE);
//        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_one://查看物流
                break;
            case R.id.btn_two://去付款-查看券码-提醒卖家发货-确认收货-再次购买
                SeeCouponCodeActivity.open(getContext());
                break;
            default:
                break;
        }
    }
}
