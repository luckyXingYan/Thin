package com.example.thin.adapter;

import android.content.Context;
import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.thin.view.BannerItemView;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class BannerImgAdapter implements CBViewHolderCreator<BannerImgAdapter.MyViewHolder> {
    private BannerItemView itemView;

    @Override
    public MyViewHolder createHolder() {
        return new MyViewHolder();
    }

    protected class MyViewHolder implements Holder<String> {
        @Override
        public View createView(Context context) {
            itemView = new BannerItemView(context);
            return itemView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            itemView.setData(data);
        }

    }
}