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
import com.example.thin.adapter.BannerHolder;
import com.example.thin.adapter.ShopDetailAdapter;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.bean.BannerBean;
import com.example.thin.bean.ShopBean;
import com.example.thin.iview.IShopDetailView;
import com.example.thin.presenter.ShopDetailPresenter;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class ShopDetailOrderActivity extends BaseActivity<ShopDetailPresenter> implements IShopDetailView, View.OnClickListener {
    private RecyclerView recyclerView;
    private ShopDetailAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private EditText content;
    private ImageView back;
    private Banner banner;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ShopDetailOrderActivity.class));
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        banner = getView(R.id.banner_shop_detail);
        back = getView(R.id.iv_back);
        content = getView(R.id.et_input_search);
        recyclerView = getView(R.id.rv_mall_detail);
        content = getView(R.id.et_input_search);
        back = getView(R.id.iv_back);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ShopDetailAdapter(this);
        recyclerView.setAdapter(adapter);

        back.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        BannerBean bean = new BannerBean();
        bean.title = "eee";
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");

        banner.setAutoPlay(true)
                .setOffscreenPageLimit(bean.url.size())
                .setPages(bean.url, new BannerHolder())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setBannerAnimation(Transformer.Default)
                .start();

        presenter.getShopDetail(this, "13");
    }

    @Override
    protected ShopDetailPresenter createPresenter() {
        return new ShopDetailPresenter();
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

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void updateData(ShopBean data) {
        adapter.setData(data);
    }
}
