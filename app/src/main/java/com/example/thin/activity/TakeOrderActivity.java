package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.adapter.TakeOrderAdapter;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.CartGoodsBean;
import com.example.thin.bean.CartListBean;
import com.example.thin.bean.OrderDataHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/24
 * @Desc:
 */
public class TakeOrderActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private RecyclerView recyclerView;
    private TakeOrderAdapter adapter;
    private CheckBox cb;
    private TextView totalNum;
    private Button btnSettlement;
    private TextView tvNewAddress;


    public static void open(Context context) {
        context.startActivity(new Intent(context, TakeOrderActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_take_order;
    }

    @Override
    protected int bottomLayoutId() {
        return R.layout.layout_settlement;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("订单信息");
        cb = getView(R.id.cb_place_order);
        totalNum = getView(R.id.tv_shop_cart);
        btnSettlement = getView(R.id.btn_settlement);
        tvNewAddress = getView(R.id.tv_new_address);

        cb.setVisibility(View.GONE);
        totalNum.setVisibility(View.VISIBLE);
        btnSettlement.setText("提交订单");
        btnSettlement.setOnClickListener(this);
        tvNewAddress.setOnClickListener(this);


        recyclerView = getView(R.id.rv_take_order);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TakeOrderAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        List<CartListBean> data = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            CartListBean bean = new CartListBean();
            bean.title = "店铺" + i;

            CartGoodsBean info = new CartGoodsBean();
            info.title = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
            info.id = "1";
            bean.goods.add(info);

            CartGoodsBean info2 = new CartGoodsBean();
            info.title = "https://img.pc841.com/2018/0922/20180922111049508.jpg";
            info.id = "2";
            bean.goods.add(info2);

            data.add(bean);
        }
        adapter.setData(OrderDataHelper.getDataAfterHandle(data));
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_settlement://提交订单 收银台
                CashierActivity.open(this);
                break;
            case R.id.tv_new_address://新建收货地址
                CreateAddressActivity.open(this);
                break;
            default:
                break;
        }
    }
}
