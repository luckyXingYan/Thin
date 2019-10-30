package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thin.R;
import com.example.thin.adapter.MallDetailImgAdapter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailImg extends BaseHomeLayout<List<String>> {
    private RecyclerView recyclerView;
    private MallDetailImgAdapter adapter;

    public MallDetailImg(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_mall_detail_img, this);
        recyclerView = findViewById(R.id.rv_mall_detail);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MallDetailImgAdapter(getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void setData(List<String> data) {
        adapter.setData(data);
    }
}
