package com.example.thin.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.HomTopTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class TypeAdapter extends BaseRecyclerAdapter<HomTopTypeBean, TypeAdapter.MyViewHolder> {
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
        myViewHolder.type.setText(getItemData(i).title);

        Drawable drawable = context.getResources().getDrawable(getItemData(i).img);
        // 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        myViewHolder.type.setCompoundDrawables(null, drawable, null, null);
    }

    protected class MyViewHolder extends BaseViewHolder {

        private TextView type;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.tv_type);
        }
    }
}
