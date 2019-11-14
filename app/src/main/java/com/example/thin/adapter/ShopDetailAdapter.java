package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.base.adapter.MyViewHolder;
import com.example.thin.bean.ShopBean;
import com.example.thin.view.ShopDetailNameLayout;
import com.example.thin.view.ShopDetailInfoLayout;
import com.example.thin.view.GoodsLayout;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class ShopDetailAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private enum ShopDetailPageType {
        NAME(0),
        INFO(1),
        IMG(2);

        private int value;

        ShopDetailPageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private ShopBean data;

    private Context context;

    public ShopDetailAdapter(Context context) {
        this.context = context;
    }

    public void setData(ShopBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ShopDetailPageType type = ShopDetailPageType.values()[i];
        MyViewHolder myViewHolder = null;
        switch (type) {
            case NAME:
                myViewHolder = new MyViewHolder(new ShopDetailNameLayout(context));
                break;
            case INFO:
                myViewHolder = new MyViewHolder(new ShopDetailInfoLayout(context));
                break;
            case IMG:
                myViewHolder = new MyViewHolder(new GoodsLayout(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (data == null) return;
        if (i == ShopDetailPageType.NAME.getValue()) {
            myViewHolder.setData(data);
        } else if (i == ShopDetailPageType.INFO.getValue()) {
            myViewHolder.setData(null);
        } else if (i == ShopDetailPageType.IMG.getValue()) {
            myViewHolder.setData(data.list);
        }
    }


    @Override
    public int getItemCount() {
        return ShopDetailPageType.values().length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
