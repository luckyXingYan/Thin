package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.base.adapter.MyViewHolder;
import com.example.thin.bean.GoodsBean;
import com.example.thin.view.EmptyFootLayout;
import com.example.thin.view.GoodsItemLayout;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class MallAdapter extends RecyclerView.Adapter<MyViewHolder<GoodsBean>> {

    private Context context;
    private static final int TYPE_FOOTER_VIEW = 1;
    private List<GoodsBean> data;

    public MallAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<GoodsBean> data) {
        this.data = data;
        notifyDataSetChanged();
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
    public int getItemViewType(int position) {
        /*当position是最后一个的时候，也就是比list的数量多一个的时候，则表示FooterView*/
        if (position == getItemCount() - 1) {
            return TYPE_FOOTER_VIEW;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (data == null) return;
        if (myViewHolder.getItemViewType() == TYPE_FOOTER_VIEW) {
            myViewHolder.setData(data);
        } else {
            myViewHolder.setData(data);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*当position是最后一个的时候，也就是比list的数量多一个的时候，则表示FooterView*/
        MyViewHolder myViewHolder = null;
        if (i == getItemCount() - 1) {
            myViewHolder = new MyViewHolder(new EmptyFootLayout(context));
        } else {
            myViewHolder = new MyViewHolder(new GoodsItemLayout(context));
        }
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }
}
