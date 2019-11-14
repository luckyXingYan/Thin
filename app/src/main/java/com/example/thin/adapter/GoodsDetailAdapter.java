package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.base.adapter.MyViewHolder;
import com.example.thin.bean.GoodsBean;
import com.example.thin.view.GoodsDetailImgItemLayout;
import com.example.thin.view.GoodsDetailInfoLayout;
import com.example.thin.view.GoodsDetailNameLayout;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class GoodsDetailAdapter extends RecyclerView.Adapter<MyViewHolder> {
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

    private GoodsBean data;

    private Context context;

    public GoodsDetailAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(GoodsBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        GoodsDetailPageType type = GoodsDetailPageType.values()[i];
        MyViewHolder myViewHolder = null;
        switch (type) {
            case NAME:
                myViewHolder = new MyViewHolder(new GoodsDetailNameLayout(context));
                break;
            case INFO:
                myViewHolder = new MyViewHolder(new GoodsDetailInfoLayout(context));
                break;
            case IMG:
                myViewHolder = new MyViewHolder(new GoodsDetailImgItemLayout(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (data == null) return;
        if (i == GoodsDetailPageType.NAME.getValue()) {
            myViewHolder.setData(data);
        } else if (i == GoodsDetailPageType.INFO.getValue()) {
            myViewHolder.setData(data);
        } else if (i == GoodsDetailPageType.IMG.getValue()) {
            myViewHolder.setData(data.rotationCharts);
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
}
