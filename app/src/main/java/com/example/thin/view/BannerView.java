package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.example.thin.R;
import com.example.thin.adapter.BannerRadiusHolder;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class BannerView extends BaseHomeLayout<List<String>> {
    private Banner banner;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_home_banner, this);
        banner = findViewById(R.id.banner);

    }

    @Override
    public void setData(List<String> data) {
        banner.setAutoPlay(true)
                .setOffscreenPageLimit(data.size())
                .setPages(data, new BannerRadiusHolder())
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setBannerAnimation(Transformer.Scale)
                .start();
    }

    public void setBannerStopAutoPlay(boolean autoPlay) {
        if (banner != null) {
            if (autoPlay) {
                banner.startAutoPlay();
            } else {
                banner.stopAutoPlay();
            }
        }
    }
}
