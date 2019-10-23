package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.HomeDataBean;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.MallDetailBanner;
import com.example.thin.view.MallDetailImg;
import com.example.thin.view.MallDetailInfo;
import com.example.thin.view.MallDetailName;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class GoodsDetailAdapter extends RecyclerView.Adapter {
    private static final int BANNER = 0;
    private static final int NAME = 1;
    private static final int INFO = 2;
    private static final int IMG = 3;
    private int type;

    private HomeDataBean data = new HomeDataBean();

    private Context context;

    public GoodsDetailAdapter(Context context, int type) {
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
            case BANNER:
                myViewHolder = new MyViewHolder(new MallDetailBanner(context));
                break;
            case NAME:
                myViewHolder = new MyViewHolder(new MallDetailName(context, type));
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
        if (i == BANNER) {
            ((MyViewHolder) viewHolder).setData(data.url);
        } else if (i == NAME) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == INFO) {
            ((MyViewHolder) viewHolder).setData(data);
        } else if (i == IMG) {
            ((MyViewHolder) viewHolder).setData(data.url);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
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
