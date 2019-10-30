package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.CartListBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartAdapter extends BaseRecyclerAdapter<CartListBean, ShopCartAdapter.MyViewHolder> {
    private Context context;
    private GoodsCartAdapter adapter;

    public ShopCartAdapter(Context context) {
        super(context);
        this.context = context;
    }

    public void setAllSelectData() {
        for (CartListBean bean : getData()) {
            adapter.setAllSelectData(bean.goods);
        }
        notifyItemRangeChanged(0, getData().size(), "checkBox");
    }

    public void setNoSelectData() {
        for (CartListBean bean : getData()) {
            adapter.setNoSelectData(bean.goods);
        }
        notifyItemRangeChanged(0, getData().size(), "checkBox");
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartListBean bean : getData()) {
            total += adapter.getTotalPrice(bean.goods);
        }
        return total;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_shop_cart;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if (payloads.isEmpty()) {
            // payloads 为 空，说明是更新整个 ViewHolder
            onBindViewHolder(holder, position);
        } else {
            // payloads 不为空，这只更新需要更新的 View 即可。
//            getTotalPrice();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.rvGoodsCart.setLayoutManager(new LinearLayoutManager(context));
        /**
         * 当确定Item的改变不会影响RecyclerView的宽高时
         * 可以设置setHasFixedSize(true)，
         * 并通过Adapter的增删改插方法去刷新RecyclerView，
         *       === 比如更新pos位置的item：notifyItemChanged(pos);/notifyItemChanged(pos,payload);而不是通过notifyDataSetChanged()。
         *       ===notifyItemRangeChanged(pos, getData().size(), "payload");
         * （其实可以直接设置为true，当需要改变宽高的时候就用 notifyDataSetChanged() 去整体刷新一下）
         * 因为删除时改变了rv的宽高，所以不用考虑 直接 notifyDataSetChanged 更新即可
         */
        myViewHolder.rvGoodsCart.setHasFixedSize(true);
        adapter = new GoodsCartAdapter(context);
        myViewHolder.rvGoodsCart.setAdapter(adapter);

        adapter.setData(getItemData(i).goods);

        adapter.setDeleteShopItemListener(new GoodsCartAdapter.DeleteShopItemListener() {
            @Override
            public void deleteShopItem() {
                if (getItemData(i).goods.size() == 0) {
                    getData().remove(getItemData(i));
                    notifyDataSetChanged();
                }
            }
        });
    }

    protected class MyViewHolder extends BaseViewHolder {

        private RecyclerView rvGoodsCart;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvGoodsCart = itemView.findViewById(R.id.rv_goods_cart);
        }
    }
}
