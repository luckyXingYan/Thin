package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class TypeAdapter extends BaseRecyclerAdapter<String, TypeAdapter.MyViewHolder> {

    public TypeAdapter(Context context) {
        super(context);
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

    }

    protected class MyViewHolder extends BaseViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
