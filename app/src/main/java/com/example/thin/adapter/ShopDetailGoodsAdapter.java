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
import com.example.thin.bean.GoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/14
 * @Desc:
 */
public class ShopDetailGoodsAdapter extends BaseRecyclerAdapter<GoodsBean, ShopDetailGoodsAdapter.MyViewHolder> {

    private Context context;

    public ShopDetailGoodsAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_mall_goods;
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public ShopDetailGoodsAdapter.MyViewHolder getViewHolder(View view, int viewType) {
        return new ShopDetailGoodsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopDetailGoodsAdapter.MyViewHolder myViewHolder, int i) {
        GoodsBean data = getItemData(i);
        if (data == null) return;
        Glide.with(context).load(data.productCover).placeholder(R.drawable.shape_rectangle_2_corners_white_stroke_gray).error(R.drawable.shape_rectangle_2_corners_white_stroke_gray).into(myViewHolder.img);
        myViewHolder.title.setText(data.productName);
        myViewHolder.price.setText(data.productPrice);
    }

    protected class MyViewHolder extends BaseViewHolder {

        private ImageView img;
        private TextView title, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_hot_img);
            title = itemView.findViewById(R.id.tv_title);
            price = itemView.findViewById(R.id.tv_price);
        }
    }
}
