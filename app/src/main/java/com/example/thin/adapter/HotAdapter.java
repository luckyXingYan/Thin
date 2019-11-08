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
import com.example.thin.bean.HotBean;
import com.example.thin.bean.HotGoodsBean;
import com.example.thin.bean.HotShopBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class HotAdapter extends BaseRecyclerAdapter<HotBean, HotAdapter.MyViewHolder> {

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
        HotShopBean hotShopBean = getItemData(i).hotShopBean;
        Glide.with(context).load(hotShopBean.shopLogo).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(myViewHolder.ivShop);
        myViewHolder.title.setText(hotShopBean.shopName);
        myViewHolder.averageConsume.setText("平均消费：" + hotShopBean.averageConsumption);
        List<HotGoodsBean> hotGoodsBeanList = getItemData(i).hotGoodsBeans;
        if (hotGoodsBeanList.size() >= 0) {
            myViewHolder.proPrice.setText(hotGoodsBeanList.get(0).productPrice);
            myViewHolder.proName.setText(hotGoodsBeanList.get(0).productName);
            myViewHolder.proPriceTwo.setText(hotGoodsBeanList.get(1).productPrice);
            myViewHolder.proNameTwo.setText(hotGoodsBeanList.get(1).productName);
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
