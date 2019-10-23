package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class HomeTypeDetailAdapter extends BaseRecyclerAdapter<String, HomeTypeDetailAdapter.MyViewHolder> {
    public HomeTypeDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_home_type_detail_layout;
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

        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
