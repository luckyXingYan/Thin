package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thin.R;
import com.example.thin.adapter.GoodsDetailImgAdapter;
import com.example.thin.bean.ImgListBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class GoodsDetailImgItemLayout extends BaseLayout<List<ImgListBean>> {
    private RecyclerView recyclerView;
    private GoodsDetailImgAdapter adapter;

    public GoodsDetailImgItemLayout(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_mall_detail_img, this);
        recyclerView = findViewById(R.id.rv_mall_detail);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GoodsDetailImgAdapter(getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void setData(List<ImgListBean> data) {
        adapter.setData(data);
    }
}
