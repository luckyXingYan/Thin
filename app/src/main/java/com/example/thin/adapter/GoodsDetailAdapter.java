package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.BannerBean;
import com.example.thin.bean.HotBean;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.MallDetailImg;
import com.example.thin.view.MallDetailInfo;
import com.example.thin.view.MallDetailName;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class GoodsDetailAdapter extends RecyclerView.Adapter {
    private enum GoodsDetailPageType {

        NAME(0),
        INFO(1),
        IMG(2);
        private int value;

        GoodsDetailPageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private int type;

    private BannerBean data = new BannerBean();

    private Context context;

    public GoodsDetailAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(BannerBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        GoodsDetailPageType type = GoodsDetailPageType.values()[i];
        MyViewHolder myViewHolder = null;
        switch (type) {
            case NAME:
                myViewHolder = new MyViewHolder(new MallDetailName(context));
                break;
            case INFO:
                myViewHolder = new MyViewHolder(new MallDetailInfo(context));
                break;
            case IMG:
                myViewHolder = new MyViewHolder(new MallDetailImg(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (data == null) return;
        if (i == GoodsDetailPageType.NAME.getValue()) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == GoodsDetailPageType.INFO.getValue()) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == GoodsDetailPageType.IMG.getValue()) {
            ((MyViewHolder) viewHolder).setData(data.url);
        }
    }

    @Override
    public int getItemCount() {
        return GoodsDetailPageType.values().length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    protected class MyViewHolder<T> extends RecyclerView.ViewHolder {
        private BaseHomeLayout itemView;

        public MyViewHolder(@NonNull BaseHomeLayout itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void setData(T data) {
            itemView.setData(data);
        }
    }
}
