package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.CartShopBean;
import com.example.thin.bean.CartGoodsBean;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.CartGoodsView;
import com.example.thin.view.CartShopView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.MyViewHolder> {
    private Context context;
    private static final int SHOP = 0;
    private static final int GOODS = 1;
    private List<Object> data;
    private CartGoodsView cartGoodsView;
    private List<CartGoodsBean> selectList;

    public ShopCartAdapter(Context context) {
        this.context = context;
        selectList = new ArrayList<>();
    }

    public void setData(List<Object> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setAllSelectData() {
        for (Object bean : data) {
            if (bean instanceof CartGoodsBean) {
                ((CartGoodsBean) bean).isSelect = true;
            }
        }
        notifyDataSetChanged();
    }

    public void setNoSelectData() {
        for (Object bean : data) {
            if (bean instanceof CartGoodsBean) {
                ((CartGoodsBean) bean).isSelect = false;
            }
        }
        notifyDataSetChanged();
    }

    public List<CartGoodsBean> getSelectData() {
        for (Object bean : data) {
            if (bean instanceof CartGoodsBean) {
                if (((CartGoodsBean) bean).isSelect) {
                    selectList.add(((CartGoodsBean) bean));
                }
            }
        }
        return selectList;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof CartShopBean) {
            return SHOP;
        } else if (data.get(position) instanceof CartGoodsBean) {
            return GOODS;
        }
        return SHOP;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = null;
        switch (i) {
            case SHOP:
                myViewHolder = new MyViewHolder(new CartShopView(context, 0));
                break;
            case GOODS:
                cartGoodsView = new CartGoodsView(context);
                myViewHolder = new MyViewHolder(cartGoodsView);
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        if (data == null) return;
        if (getItemViewType(i) == SHOP) {//店铺
            myViewHolder.setData(data.get(i));
        } else if (i == GOODS) {//商品
            myViewHolder.setData(data.get(i));
        }

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
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
