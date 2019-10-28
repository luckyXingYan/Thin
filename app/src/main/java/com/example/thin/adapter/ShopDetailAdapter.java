package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.HomeDataBean;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.ShopDetailName;
import com.example.thin.view.ShopDetailSpecial;
import com.example.thin.view.ShopDetailView;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class ShopDetailAdapter extends RecyclerView.Adapter {
    private static final int NAME = 0;
    private static final int INFO = 1;
    private static final int IMG = 2;
    private int type;

    private HomeDataBean data = new HomeDataBean();

    private Context context;

    public ShopDetailAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    public void setData(HomeDataBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = null;
        switch (i) {
            case NAME:
                myViewHolder = new MyViewHolder(new ShopDetailName(context));
                break;
            case INFO:
                myViewHolder = new MyViewHolder(new ShopDetailSpecial(context));
                break;
            case IMG:
                myViewHolder = new MyViewHolder(new ShopDetailView(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (data == null) return;
        if (i == NAME) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == INFO) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == IMG) {
            ((MyViewHolder) viewHolder).setData(data.url);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
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
