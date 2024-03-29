package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.thin.R;
import com.example.thin.adapter.BannerHolder;
import com.example.thin.adapter.GoodsDetailAdapter;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.bean.BannerBean;
import com.example.thin.bean.GoodsBean;
import com.example.thin.iview.IGoodsDetailView;
import com.example.thin.presenter.GoodsDetailPresenter;
import com.example.thin.util.Constants;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class GoodsDetailActivity extends BaseActivity<GoodsDetailPresenter> implements IGoodsDetailView, View.OnClickListener {
    private RecyclerView recyclerView;
    private GoodsDetailAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ImageView back, shopCart;
    private RelativeLayout rlShopCart;
    private EditText content;
    private Banner banner;
    private String proId;
    private int count;
    private Button add, shop;
    private boolean isClickable = true;

    public static void open(Context context, String proId) {
        Intent intent = new Intent(context, GoodsDetailActivity.class);
        intent.putExtra(Constants.PRO_ID, proId);
        context.startActivity(intent);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        proId = getIntent().getStringExtra(Constants.PRO_ID);
        recyclerView = getView(R.id.rv_mall_detail);
        banner = getView(R.id.banner_goods_detail);
        back = getView(R.id.iv_back);
        content = getView(R.id.et_input_search);
        shopCart = getView(R.id.iv_shop_cart);
        rlShopCart = getView(R.id.rl_shop_cart);
        add = getView(R.id.btn_add);
        shop = getView(R.id.btn_shop);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new GoodsDetailAdapter(this, 1);
        recyclerView.setAdapter(adapter);
        back.setOnClickListener(this);
        rlShopCart.setOnClickListener(this);
        add.setOnClickListener(this);
        shop.setOnClickListener(this);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    isClickable = true;
                }
            }
        };
        timer.start();

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

        presenter.getGoodsDetail(this, proId);
    }

    @Override
    protected GoodsDetailPresenter createPresenter() {
        return new GoodsDetailPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back://返回
                finish();
                break;
            case R.id.btn_add://加入购物车
                if (isClickable) {
                    count++;
                    presenter.addCart(this, proId, count + "");
                    isClickable = false;
                }
                break;
            case R.id.btn_shop://立即购买
                break;
            case R.id.rl_shop_cart://购物车
                ShopCartActivity.open(this);
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
    public void updateData(GoodsBean data) {
        adapter.setData(data);
    }

    @Override
    public void addCart() {

    }
}
