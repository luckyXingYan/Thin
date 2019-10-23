package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thin.R;
import com.example.thin.adapter.ShopCartAdapter;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.OrderDataHelper;
import com.example.thin.bean.CartGoodsBean;
import com.example.thin.bean.CartListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView {

    private RecyclerView recyclerView;
    private ShopCartAdapter adapter;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ShopCartActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shop_cart;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("购物车");

        recyclerView = getView(R.id.rv_shop_cart);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopCartAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        List<CartListBean> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
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

}
