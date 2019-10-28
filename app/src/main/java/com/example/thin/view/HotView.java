package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.R;
import com.example.thin.activity.GoodsDetailActivity;
import com.example.thin.activity.ShopDetailActivity;
import com.example.thin.adapter.HotAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class HotView extends BaseHomeLayout<List<String>> {
    private RecyclerView recyclerView;
    private HotAdapter adapter;

    public HotView(Context context) {
        this(context, null);
    }

    public HotView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_home_hot, this);
        recyclerView = findViewById(R.id.rv_home_hot);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        adapter = new HotAdapter(getContext());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, String s, int position) {
                ShopDetailActivity.open(getContext());
            }
        });
    }

    @Override
    public void setData(List<String> data) {
        adapter.setData(data);
    }
}
