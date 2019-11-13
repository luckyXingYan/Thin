package com.example.thin.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.example.thin.activity.GoodsDetailActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.GoodsBean;
import com.example.thin.eventbus.TotalPriceEvent;
import com.example.thin.util.Constants;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/30
 * @Desc:
 */
public class GoodsAdapter extends BaseRecyclerAdapter<GoodsBean, GoodsAdapter.MyViewHolder> {
    private Context context;


    public GoodsAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_goods;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            // payloads 为 空，说明是更新整个 ViewHolder
            onBindViewHolder(holder, position);
        } else {
            // payloads 不为空，这只更新需要更新的 View 即可。
            for (Object payload : payloads) {
                String payloadStr = ((String) payload);
                if (Constants.CHECK_BOX_GOODS.equals(payloadStr)) {
                    holder.checkBox.setChecked(getItemData(position).isSelect);//更新是否选中
                    //通知更新合计总价（重新遍历集合计算总价）
                    EventBus.getDefault().post(TotalPriceEvent.getInstance());
                } else if (Constants.TV_NUM.equals(payloadStr)) {
                    holder.tvNum.setText(getItemData(position).count);
                }
            }

        }

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final GoodsBean data = getItemData(i);
        if (data == null) return;
        myViewHolder.checkBox.setChecked(data.isSelect);
        Glide.with(context).load(data.imgUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(myViewHolder.ivIcon);
        myViewHolder.name.setText(data.productName);
        myViewHolder.price.setText(data.unitPrice);
        myViewHolder.tvNum.setText(data.count);
        //选中
        myViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!data.isSelect) {
                    data.isSelect = true;
                } else {
                    data.isSelect = false;
                }
                notifyItemChanged(i, Constants.CHECK_BOX_GOODS);//只更新item布局中的checkBox
            }
        });
        //商品详情
        myViewHolder.rlGoodsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailActivity.open(context, "");
            }
        });
        //长按删除
        myViewHolder.rlGoodsDetail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context).setTitle("确认删除吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, int which) {
                                dialog.dismiss();
                                getData().remove(data);
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

        //num  加
        myViewHolder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(data.count);
                if (count == 10) {
                    return;
                }
                data.count = ++count + "";

                notifyItemChanged(i, Constants.TV_NUM);//只更新item布局中的checkBox
                if (myViewHolder.checkBox.isChecked()) {
                    //通知更新合计总价（重新遍历集合计算总价）
                    EventBus.getDefault().post(TotalPriceEvent.getInstance());
                }
            }
        });
        //num 减
        myViewHolder.ivSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(data.count);
                if (count == 1) {
                    return;
                }
                data.count = --count + "";

                notifyItemChanged(i, Constants.TV_NUM);//只更新item布局中的checkBox
                if (myViewHolder.checkBox.isChecked()) {
                    //通知更新合计总价（重新遍历集合计算总价）
                    EventBus.getDefault().post(TotalPriceEvent.getInstance());
                }
            }
        });

    }

    public void setAllSelectData(final List<GoodsBean> goods) {
        for (int i = 0; i < goods.size(); i++) {
            goods.get(i).isSelect = true;
        }
    }

    public void setNoSelectData(final List<GoodsBean> goods) {
        for (int i = 0; i < goods.size(); i++) {
            goods.get(i).isSelect = false;
        }
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    protected class MyViewHolder extends BaseViewHolder {
        private CheckBox checkBox;
        private ImageView ivIcon, ivSub;
        private TextView tvNum, name, price;
        private ImageView ivAdd;
        private RelativeLayout rlGoodsDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cb_cart_shop);
            ivIcon = itemView.findViewById(R.id.iv_cart);
            name = itemView.findViewById(R.id.iv_cart_goods_name);
            price = itemView.findViewById(R.id.tv_goods_price);
            ivSub = itemView.findViewById(R.id.iv_sub);
            tvNum = itemView.findViewById(R.id.tv_num);
            ivAdd = itemView.findViewById(R.id.iv_add);
            rlGoodsDetail = itemView.findViewById(R.id.rl_goods_detail);

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
