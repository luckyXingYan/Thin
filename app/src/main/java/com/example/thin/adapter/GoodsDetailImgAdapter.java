package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.example.thin.activity.ZoomImgActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.ImgListBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class GoodsDetailImgAdapter extends BaseRecyclerAdapter<ImgListBean, GoodsDetailImgAdapter.MyViewHolder> {

    private Context context;

    public GoodsDetailImgAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_mall_detail_img;
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
        final ImgListBean data = getItemData(i);
        if (data == null) return;
        Glide.with(context).load(data.imgUrl).placeholder(R.drawable.shape_rectangle_2_corners_white_stroke_gray).error(R.drawable.shape_rectangle_2_corners_white_stroke_gray).into(myViewHolder.img);
        myViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImgActivity.open(context, data.imgUrl);
            }
        });
    }

    protected class MyViewHolder extends BaseViewHolder {

        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_mall_detail_img);
        }
    }
}
