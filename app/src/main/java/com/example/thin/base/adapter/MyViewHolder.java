package com.example.thin.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.thin.view.BaseLayout;

/**
 * @Author: xingyan
 * @Date: 2019/11/14
 * @Desc:
 */
public class MyViewHolder<T> extends RecyclerView.ViewHolder {
    private BaseLayout itemView;

    public MyViewHolder(@NonNull BaseLayout itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void setData(T data) {
        itemView.setData(data);
    }
}
