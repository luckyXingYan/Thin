package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.thin.R;
import com.example.thin.adapter.HotAdapter;

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
    }

    @Override
    public void setData(List<String> data) {
        adapter.setData(data);
    }
}
