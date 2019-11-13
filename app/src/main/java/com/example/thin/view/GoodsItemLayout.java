package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.R;
import com.example.thin.activity.GoodsDetailActivity;
import com.example.thin.adapter.MallAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.bean.GoodsBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class GoodsItemLayout extends BaseLayout<List<GoodsBean>> {
    private RecyclerView recyclerView;
    private MallAdapter adapter;

    public GoodsItemLayout(Context context) {
        this(context, null);
    }

    public GoodsItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_shop_detail, this);
        recyclerView = findViewById(R.id.rv_home_hot);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        adapter = new MallAdapter(getContext());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<GoodsBean>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, GoodsBean bean, int position) {
                GoodsDetailActivity.open(getContext(),adapter.getItemData(position).pid);
            }
        });
    }

    @Override
    public void setData(List<GoodsBean> data) {
        adapter.setData(data);
    }
}
