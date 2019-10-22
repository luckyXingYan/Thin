package com.example.thin.adapter;

import android.content.Context;
import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.thin.view.BannerItemView;
import com.example.thin.view.MallBannerItemView;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class MallBannerAdapter implements CBViewHolderCreator<MallBannerAdapter.MyViewHolder> {
    private MallBannerItemView itemView;

    @Override
    public MyViewHolder createHolder() {
        return new MyViewHolder();
    }

    protected class MyViewHolder implements Holder<String> {
        @Override
        public View createView(Context context) {
            itemView = new MallBannerItemView(context);
            return itemView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            itemView.setData(data);
        }

    }
}