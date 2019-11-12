package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.ShopBean;
import com.example.thin.bean.GoodsBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class HotAdapter extends BaseRecyclerAdapter<ShopBean, HotAdapter.MyViewHolder> {

    private Context context;

    public HotAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_home_hot;
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
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ShopBean hotBean = getItemData(i);
        Glide.with(context).load(hotBean.shopLogo).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(myViewHolder.ivShop);
        myViewHolder.title.setText(hotBean.shopName);
        myViewHolder.averageConsume.setText("平均消费：" + hotBean.averageConsumption);
        List<GoodsBean> hotGoodsBeanList = getItemData(i).list;
        if (hotGoodsBeanList.size() > 0) {
            if (hotGoodsBeanList.size() == 1) {
                myViewHolder.proPriceTwo.setVisibility(View.GONE);
                myViewHolder.proNameTwo.setVisibility(View.GONE);
                myViewHolder.proPrice.setText(hotGoodsBeanList.get(0).productPrice);
                myViewHolder.proName.setText(hotGoodsBeanList.get(0).productName);
                return;
            }
            myViewHolder.proPriceTwo.setVisibility(View.VISIBLE);
            myViewHolder.proNameTwo.setVisibility(View.VISIBLE);
            myViewHolder.proPriceTwo.setText(hotGoodsBeanList.get(1).productPrice);
            myViewHolder.proNameTwo.setText(hotGoodsBeanList.get(1).productName);
        } else {
            myViewHolder.proPrice.setVisibility(View.GONE);
            myViewHolder.proName.setVisibility(View.GONE);
            myViewHolder.proPriceTwo.setVisibility(View.GONE);
            myViewHolder.proNameTwo.setVisibility(View.GONE);
        }
    }

    protected class MyViewHolder extends BaseViewHolder {

        private TextView title, averageConsume, proPrice, proName, proPriceTwo, proNameTwo;
        private ImageView ivShop;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivShop = itemView.findViewById(R.id.iv_hot_img);
            title = itemView.findViewById(R.id.tv_title);
            averageConsume = itemView.findViewById(R.id.tv_average_consume);
            proPrice = itemView.findViewById(R.id.tv_price_one);
            proName = itemView.findViewById(R.id.tv_detail_one);
            proPriceTwo = itemView.findViewById(R.id.tv_price_two);
            proNameTwo = itemView.findViewById(R.id.tv_detail_two);
        }
    }
}
