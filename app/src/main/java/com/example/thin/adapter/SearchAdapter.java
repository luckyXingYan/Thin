package com.example.thin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.thin.base.adapter.MyViewHolder;
import com.example.thin.view.BaseLayout;
import com.example.thin.view.SearchLayout;
import com.example.thin.view.SearchItemLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class SearchAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private enum SearchPageType {

        RECENT_SEARCH(0),
        RECENT_SEARCH_GV(1),
        HOT_SEARCH(2),
        HOT_SEARCH_GV(3);

        private int value;

        SearchPageType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private Context context;
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
        SearchPageType type = SearchPageType.values()[i];
        MyViewHolder myViewHolder = null;
        switch (type) {
            case RECENT_SEARCH:
                myViewHolder = new MyViewHolder(new SearchItemLayout(context, 0));
                break;
            case RECENT_SEARCH_GV:
                myViewHolder = new MyViewHolder(new SearchLayout(context, 0));
                break;
            case HOT_SEARCH:
                myViewHolder = new MyViewHolder(new SearchItemLayout(context, 1));
                break;
            case HOT_SEARCH_GV:
                myViewHolder = new MyViewHolder(new SearchLayout(context, 1));
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (data == null) return;
        if (getItemViewType(i) == SearchPageType.RECENT_SEARCH.getValue()) {
            myViewHolder.setData(data.get(i));
        } else if (i == SearchPageType.RECENT_SEARCH_GV.getValue()) {
            myViewHolder.setData(data.get(i));
        } else if (i == SearchPageType.HOT_SEARCH.getValue()) {
            myViewHolder.setData(data.get(i));
        } else if (i == SearchPageType.HOT_SEARCH_GV.getValue()) {
            myViewHolder.setData(data.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return SearchPageType.values().length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
