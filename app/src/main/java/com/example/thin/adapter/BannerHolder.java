package com.example.thin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.ms.banner.holder.BannerViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/28
 * @Desc:
 */
public class BannerHolder implements BannerViewHolder<String> {

    @Override
    public View createView(Context context, int position, String data) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner_layout, null);
        ImageView banner = view.findViewById(R.id.iv_bg);
        Glide.with(context).load(data).placeholder(R.color.color_e7).error(R.mipmap.ic_launcher).into(banner);
        return view;
    }
}
