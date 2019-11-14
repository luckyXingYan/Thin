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
import com.example.thin.bean.TypeBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class TypeAdapter extends BaseRecyclerAdapter<TypeBean, TypeAdapter.MyViewHolder> {
    private Context context;

    public TypeAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_home_type;
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
        TypeBean bean = getItemData(i);
        if (bean == null) return;
        myViewHolder.type.setText(bean.name);
        Glide.with(context).load(R.mipmap.liposuction).placeholder(R.drawable.shape_rectangle_2_corners_white_stroke_gray).error(R.drawable.shape_rectangle_2_corners_white_stroke_gray).into(myViewHolder.ivType);
    }

    protected class MyViewHolder extends BaseViewHolder {

        private TextView type;
        private ImageView ivType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.tv_type);
            ivType = itemView.findViewById(R.id.iv_type);
        }
    }
}
