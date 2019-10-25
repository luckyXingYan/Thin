package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.thin.R;
import com.example.thin.adapter.ShopDetailAdapter;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.HomeDataBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class ShopDetailActivity extends BaseActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private RecyclerView recyclerView;
    private ShopDetailAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private EditText content;
    private ImageView back;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ShopDetailActivity.class));
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        back = getView(R.id.iv_back);
        content = getView(R.id.et_input_search);
        recyclerView = getView(R.id.rv_mall_detail);
        content = getView(R.id.et_input_search);
        back = getView(R.id.iv_back);
        recyclerView.setHasFixedSize(false);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ShopDetailAdapter(this, 0);
        recyclerView.setAdapter(adapter);

        back.setOnClickListener(this);
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
            case R.id.iv_back://返回
                finish();
                break;
            default:
                break;
        }
    }
}
