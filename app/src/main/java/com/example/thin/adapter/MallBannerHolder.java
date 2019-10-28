package com.example.thin.adapter;

import android.content.Context;
import android.view.View;

import com.example.thin.view.MallBannerItemView;
import com.ms.banner.holder.BannerViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class MallBannerHolder implements BannerViewHolder<String> {
    private MallBannerItemView itemView;

    @Override
    public View createView(Context context, int position, String data) {
        itemView = new MallBannerItemView(context);
        return itemView;
    }

}