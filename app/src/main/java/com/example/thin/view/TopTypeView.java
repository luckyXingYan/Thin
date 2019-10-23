package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.R;
import com.example.thin.activity.HomeTypeDetailActivity;
import com.example.thin.adapter.TypeAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class TopTypeView extends BaseHomeLayout<List<String>> {
    private RecyclerView recyclerView;
    private TypeAdapter adapter;

    public TopTypeView(Context context) {
        this(context, null);
    }

    public TopTypeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_home_top_type, this);
        recyclerView = findViewById(R.id.rv_home_type);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        adapter = new TypeAdapter(getContext());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, String s, int position) {
                HomeTypeDetailActivity.open(getContext());
            }
        });
    }


    @Override
    public void setData(List<String> data) {
        adapter.setData(data);
    }
}
