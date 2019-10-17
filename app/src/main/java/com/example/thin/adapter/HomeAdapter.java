package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.view.BannerView;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.TopTypeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class HomeAdapter extends RecyclerView.Adapter {
    private static final int TYPE = 0;
    private static final int BANNER = 1;

    private List<String> data = new ArrayList<>();

    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = null;
        switch (i) {
            case TYPE:
                myViewHolder = new MyViewHolder(new TopTypeView(context));
                break;
            case BANNER:
                myViewHolder = new MyViewHolder(new BannerView(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (data == null) return;
        if (i == TYPE) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == BANNER) {
            ((MyViewHolder) viewHolder).setData(data);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
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
