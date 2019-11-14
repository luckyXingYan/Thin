package com.example.thin.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.example.thin.activity.GoodsDetailActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.bean.GoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/14
 * @Desc:
 */
public class GoodsItemLayout extends BaseLayout<GoodsBean> {
    private Context context;
    private ImageView img;
    private TextView title, price;
    private RelativeLayout root;

    public GoodsItemLayout(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.item_mall_goods, this);
        img = findViewById(R.id.iv_hot_img);
        title = findViewById(R.id.tv_title);
        price = findViewById(R.id.tv_price);
        root = findViewById(R.id.rl_root);

        root.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailActivity.open(context, "");
            }
        });
    }

    @Override
    public void setData(GoodsBean data) {
        Glide.with(context).load(data.productCover).placeholder(R.drawable.shape_rectangle_2_corners_white_stroke_gray).error(R.drawable.shape_rectangle_2_corners_white_stroke_gray).into(img);
        title.setText(data.productName);
        price.setText(data.productPrice);
    }
}
