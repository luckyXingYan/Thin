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

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class HotAdapter extends BaseRecyclerAdapter<String, HotAdapter.MyViewHolder> {

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

//        Glide.with(context).load(getItemData(i)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(myViewHolder.img);
    }

    protected class MyViewHolder extends BaseViewHolder {

        private TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
