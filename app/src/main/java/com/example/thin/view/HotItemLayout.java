package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.R;
import com.example.thin.activity.ShopDetailActivity;
import com.example.thin.adapter.HotAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.bean.ShopBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class HotItemLayout extends BaseLayout<List<ShopBean>> {
    private RecyclerView recyclerView;
    private HotAdapter adapter;

    public HotItemLayout(Context context) {
        this(context, null);
    }

    public HotItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_home_hot, this);
        recyclerView = findViewById(R.id.rv_home_hot);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        adapter = new HotAdapter(getContext());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<ShopBean>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, ShopBean bean, int position) {
                ShopDetailActivity.open(getContext(),adapter.getItemData(position).id);
            }
        });
    }

    @Override
    public void setData(List<ShopBean> data) {
        adapter.setData(data);
    }
}
