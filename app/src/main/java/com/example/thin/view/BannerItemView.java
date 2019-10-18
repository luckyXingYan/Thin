package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class BannerItemView extends BaseHomeLayout<String> {

    private ImageView banner;

    public BannerItemView(Context context) {
        this(context, null);
    }

    public BannerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.item_banner_img_layout, this);
        banner = findViewById(R.id.iv_bg);
    }

    @Override
    public void setData(String data) {
        Glide.with(getContext()).load(data).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(banner);
    }


}
