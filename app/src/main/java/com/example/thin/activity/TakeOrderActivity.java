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
import com.example.thin.util.Constants;

import java.io.Serializable;
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
    private TextView tvNewAddress, tvTotalPrice;
    private String totalNumOfShops, totalPriceOfShops;
    private List<CartListBean> listCart;


    public static void open(Context context, List<CartListBean> listCart, String totalNumOfShops, String totalPriceOfShops) {
        Intent intent = new Intent(context, TakeOrderActivity.class);
        intent.putExtra(Constants.LIST_CART, (Serializable) listCart);
        intent.putExtra(Constants.TOTAL_NUM_OF_SHOPS, totalNumOfShops);
        intent.putExtra(Constants.TOTAL_PRICE_OF_SHOPS, totalPriceOfShops);
        context.startActivity(intent);
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
        listCart = (List<CartListBean>) getIntent().getSerializableExtra(Constants.LIST_CART);
        totalNumOfShops = getIntent().getStringExtra(Constants.TOTAL_NUM_OF_SHOPS);
        totalPriceOfShops = getIntent().getStringExtra(Constants.TOTAL_PRICE_OF_SHOPS);
        mTitleBar.setTitle("订单信息");
        cb = getView(R.id.cb_all_select);
        totalNum = getView(R.id.tv_shop_cart);
        btnSettlement = getView(R.id.btn_settlement);
        tvNewAddress = getView(R.id.tv_new_address);
        tvTotalPrice = getView(R.id.tv_total);

        cb.setVisibility(View.GONE);
        totalNum.setVisibility(View.VISIBLE);
        btnSettlement.setText("提交订单");
        btnSettlement.setOnClickListener(this);
        tvNewAddress.setOnClickListener(this);


        recyclerView = getView(R.id.rv_take_order);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TakeOrderAdapter(this);
        recyclerView.setAdapter(adapter);

        totalNum.setText("共计 " + totalNumOfShops + " 件");
        tvTotalPrice.setText(totalPriceOfShops);

    }

    @Override
    protected void initData() {
        adapter.setData(OrderDataHelper.getDataAfterHandle(listCart));
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
