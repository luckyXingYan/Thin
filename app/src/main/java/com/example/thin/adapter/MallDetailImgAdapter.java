package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.example.thin.R;
import com.example.thin.activity.ZoomImgActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class MallDetailImgAdapter extends BaseRecyclerAdapter<String, MallDetailImgAdapter.MyViewHolder> {

    private Context context;

    public MallDetailImgAdapter(Context context) {
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
//        Glide.with(context).load(getItemData(i)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(myViewHolder.img);
        myViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImgActivity.open(context);
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
