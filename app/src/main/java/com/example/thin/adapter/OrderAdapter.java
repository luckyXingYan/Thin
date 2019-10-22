package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class OrderAdapter extends BaseRecyclerAdapter<String, OrderAdapter.MyViewHolder> {

    public OrderAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_order;
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
//        myViewHolder.name.setText(getItemData(i));

    }

    protected class MyViewHolder extends BaseViewHolder {

        private TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.shop_name);
        }
    }
}
