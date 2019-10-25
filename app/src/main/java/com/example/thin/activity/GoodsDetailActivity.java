package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.thin.R;
import com.example.thin.adapter.GoodsDetailAdapter;
import com.example.thin.base.BaseTitleBarActivity;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.HomeDataBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class GoodsDetailActivity extends BaseActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private RecyclerView recyclerView;
    private GoodsDetailAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ImageView shopCart;
    private RelativeLayout rlShopCart;

    public static void open(Context context) {
        context.startActivity(new Intent(context, GoodsDetailActivity.class));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        recyclerView = getView(R.id.rv_mall_detail);
        shopCart = getView(R.id.iv_shop_cart);
        rlShopCart = getView(R.id.rl_shop_cart);
        recyclerView.setHasFixedSize(false);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new GoodsDetailAdapter(this, 1);
        recyclerView.setAdapter(adapter);
        rlShopCart.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        HomeDataBean bean = new HomeDataBean();
        bean.title = "eee";
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");

        adapter.setData(bean);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_shop_cart://购物车
                ShopCartActivity.open(this);
                break;
            default:
                break;
        }
    }
}
