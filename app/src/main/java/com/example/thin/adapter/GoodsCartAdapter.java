package com.example.thin.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.CartGoodsBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/30
 * @Desc:
 */
public class GoodsCartAdapter extends BaseRecyclerAdapter<CartGoodsBean, GoodsCartAdapter.MyViewHolder> {
    private Context context;

    public GoodsCartAdapter(Context context) {
        super(context);
        this.context = context;
    }

    public void setAllSelectData(List<CartGoodsBean> goods) {
        for (int i = 0; i < goods.size(); i++) {
            goods.get(i).isSelect = true;
        }
        notifyItemRangeChanged(0, goods.size(), "checkBox");//只更新item布局中的checkBox
    }

    public void setNoSelectData(List<CartGoodsBean> goods) {
        for (int i = 0; i < goods.size(); i++) {
            goods.get(i).isSelect = false;
        }
        notifyItemRangeChanged(0, goods.size(), "checkBox");//只更新item布局中的checkBox
    }

    private double total, prices;
    private int nums;

    public double getTotalPrice(List<CartGoodsBean> goods) {
        total = 0;
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).isSelect) {
                String num = goods.get(i).num;
                nums = Integer.valueOf(num);
                String price = goods.get(i).price;
                prices = Double.valueOf(price);
                total += nums * prices;
            }
        }
        return total;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_goods_cart;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            // payloads 为 空，说明是更新整个 ViewHolder
            onBindViewHolder(holder, position);
        } else {
            // payloads 不为空，这只更新需要更新的 View 即可。
            holder.checkBox.setChecked(getItemData(position).isSelect);
            getTotalPrice(getData());
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.checkBox.setChecked(getItemData(i).isSelect);
        myViewHolder.llItemShopCartGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//选中
                if (!getItemData(i).isSelect) {
                    getItemData(i).isSelect = true;
                } else {
                    getItemData(i).isSelect = false;
                }
                notifyItemChanged(i, "checkBox");//只更新item布局中的checkBox
            }
        });
        myViewHolder.llItemShopCartGoods.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {//删除
                new AlertDialog.Builder(context).setTitle("确认删除吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, int which) {
                                dialog.dismiss();
                                getData().remove(getItemData(i));
                                notifyDataSetChanged();
                                if (getItemCount() == 0) {
                                    if (deleteShopItemListener != null) {
                                        deleteShopItemListener.deleteShopItem();
                                    }
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                return true;
            }
        });

    }

    protected class MyViewHolder extends BaseViewHolder {
        private LinearLayout llItemShopCartGoods;
        private CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            llItemShopCartGoods = itemView.findViewById(R.id.ll_item_shop_cart_goods);
            checkBox = itemView.findViewById(R.id.cb_cart_shop);
        }
    }

    private DeleteShopItemListener deleteShopItemListener;

    protected interface DeleteShopItemListener {
        void deleteShopItem();
    }

    public void setDeleteShopItemListener(DeleteShopItemListener deleteShopItemListener) {
        this.deleteShopItemListener = deleteShopItemListener;
    }
}
