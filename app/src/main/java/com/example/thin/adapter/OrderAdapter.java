package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.GoodBean;
import com.example.thin.bean.ShopTempBean;
import com.example.thin.bean.OrderBottomBean;
import com.example.thin.view.BaseLayout;
import com.example.thin.view.OrderShopLayout;
import com.example.thin.view.OrderItemBottomLayout;
import com.example.thin.view.OrderGoodsItemLayout;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private Context context;
    private static final int SHOP = 0;
    private static final int GOODS = 1;
    private static final int FOOT = 2;
    private List<Object> data;

    public OrderAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Object> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof ShopTempBean) {
            return SHOP;
        } else if (data.get(position) instanceof GoodBean) {
            return GOODS;
        } else if (data.get(position) instanceof OrderBottomBean) {
            return FOOT;
        }
        return SHOP;
    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = null;
        switch (i) {
            case SHOP:
                myViewHolder = new MyViewHolder(new OrderShopLayout(context));
                break;
            case GOODS:
                myViewHolder = new MyViewHolder(new OrderGoodsItemLayout(context));
                break;
            case FOOT:
                myViewHolder = new MyViewHolder(new OrderItemBottomLayout(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (data == null) return;
        if (getItemViewType(i) == SHOP) {
            myViewHolder.setData(data.get(i));
        } else if (i == GOODS) {
            myViewHolder.setData(data.get(i));
        } else if (i == FOOT) {
            myViewHolder.setData(data.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    protected class MyViewHolder<T> extends RecyclerView.ViewHolder {
        private BaseLayout itemView;

        public MyViewHolder(@NonNull BaseLayout itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void setData(T data) {
            itemView.setData(data);
        }
    }
}
