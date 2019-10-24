package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.bean.CartGoodsBean;
import com.example.thin.bean.CartShopBean;
import com.example.thin.bean.FootBean;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.view.BannerView;
import com.example.thin.view.BaseHomeLayout;
import com.example.thin.view.CartGoodsView;
import com.example.thin.view.CartShopView;
import com.example.thin.view.HomeFootView;
import com.example.thin.view.HotView;
import com.example.thin.view.OrderFootView;
import com.example.thin.view.SearchGvView;
import com.example.thin.view.SearchView;
import com.example.thin.view.TopTypeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private Context context;
    private static final int RECENT_SEARCH = 0;
    private static final int RECENT_SEARCH_GV = 1;
    private static final int HOT_SEARCH = 2;
    private static final int HOT_SEARCH_GV = 3;
    private List<String> data = new ArrayList<>();

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = null;
        switch (i) {
            case RECENT_SEARCH:
                myViewHolder = new MyViewHolder(new SearchView(context, 0));
                break;
            case RECENT_SEARCH_GV:
                myViewHolder = new MyViewHolder(new SearchGvView(context));
                break;
            case HOT_SEARCH:
                myViewHolder = new MyViewHolder(new SearchView(context, 1));
                break;
            case HOT_SEARCH_GV:
                myViewHolder = new MyViewHolder(new SearchGvView(context));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.MyViewHolder myViewHolder, int i) {
        if (data == null) return;
        if (getItemViewType(i) == RECENT_SEARCH) {
            myViewHolder.setData(data.get(i));
        } else if (i == RECENT_SEARCH_GV) {
            myViewHolder.setData(data.get(i));
        } else if (i == HOT_SEARCH) {
            myViewHolder.setData(data.get(i));
        } else if (i == HOT_SEARCH_GV) {
            myViewHolder.setData(data.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    protected class MyViewHolder<T> extends RecyclerView.ViewHolder {
        private BaseHomeLayout itemView;

        public MyViewHolder(@NonNull BaseHomeLayout itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void setData(T data) {
            itemView.setData(data);
        }
    }
}
