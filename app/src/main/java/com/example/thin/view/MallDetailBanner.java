package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.thin.R;
import com.example.thin.adapter.MallBannerAdapter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailBanner extends BaseHomeLayout<List<String>> {
    private ConvenientBanner convenientBanner;

    public MallDetailBanner(Context context) {
        this(context, null);
    }

    public MallDetailBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_mall_detail_banner, this);
        convenientBanner = findViewById(R.id.convenientBanner);
    }

    @Override
    public void setData(List<String> data) {
        convenientBanner.getViewPager().setOffscreenPageLimit(data.size());
        convenientBanner.setPages(new MallBannerAdapter(), data);
    }
}
