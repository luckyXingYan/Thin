package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.thin.R;
import com.example.thin.adapter.BannerImgAdapter;
import com.example.thin.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class BannerView extends BaseHomeLayout<List<String>> {
    private ConvenientBanner convenientBanner;
    private List<String> data = new ArrayList<>();

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_home_banner, this);
        convenientBanner = findViewById(R.id.convenientBanner);
    }

    @Override
    public void setData(List<String> data) {
        this.data = data;

        convenientBanner.getViewPager().setOffscreenPageLimit(data.size());
        convenientBanner.getViewPager().setPageTransformer(true, new ScaleTransformer());
        convenientBanner.getViewPager().setPageMargin(ScreenUtil.dip2px(getContext(), 10));//间距
//        convenientBanner.setPadding(ScreenUtil.dip2px(getContext(), 20), 0, ScreenUtil.dip2px1
// (getContext(), 20), 0);//间距
        convenientBanner.setPages(new BannerImgAdapter(), data);
    }

}
