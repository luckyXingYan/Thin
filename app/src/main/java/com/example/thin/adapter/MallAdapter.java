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
 * @Date: 2019/10/17
 * @Desc:
 */
public class MallAdapter extends BaseRecyclerAdapter<GoodsBean, MallAdapter.MyViewHolder> {

    private Context context;
//    private static final int TYPE_FOOTER_VIEW = 1;

    public MallAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getItemLayout(int viewType) {
//        if (viewType == TYPE_FOOTER_VIEW) {
//            /*这里返回的是FooterView*/
//            return R.layout.layout_home_foot;
//        } else {
        /*这里返回的是普通的View*/
        return R.layout.item_mall_goods;
//        }
    }

    /**
     * 判断是否是Footer的位置
     * 如果是Footer的位置则返回true否则返回false
     *
     * @param position
     * @return
     */
    public boolean isFooter(int position) {
        return position == getItemCount() - 1;
    }

    @Override
    public int getViewType(int position) {
//        /*当position是最后一个的时候，也就是比list的数量多一个的时候，则表示FooterView*/
//        if (position == getItemCount() - 1) {
//            return TYPE_FOOTER_VIEW;
//        }
        return 0;
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        if (myViewHolder.getItemViewType() == 0) {
        GoodsBean data = getItemData(i);
        if (data == null) return;
        Glide.with(context).load(data.productCover).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(myViewHolder.img);
        myViewHolder.title.setText(data.productName);
        myViewHolder.price.setText(data.productPrice);
//        }
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
