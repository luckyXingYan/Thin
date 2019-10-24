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
import com.example.thin.bean.HomTopTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class TopTypeView extends BaseHomeLayout<List<String>> {
    private RecyclerView recyclerView;
    private TypeAdapter adapter;
    private List<HomTopTypeBean> types = new ArrayList<>();

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

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<HomTopTypeBean>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, HomTopTypeBean homTopTypeBean, int position) {
                HomeTypeDetailActivity.open(getContext());
            }
        });
    }


    @Override
    public void setData(List<String> data) {
        HomTopTypeBean bean1 = new HomTopTypeBean();
        bean1.id = 1;
        bean1.title = "吸脂";
        bean1.img = R.mipmap.liposuction;

        HomTopTypeBean bean2 = new HomTopTypeBean();
        bean2.id = 2;
        bean2.title = "埋线减肥";
        bean2.img = R.mipmap.catgut_embedding;


        HomTopTypeBean bean3 = new HomTopTypeBean();
        bean3.id = 3;
        bean3.title = "针灸减肥";
        bean3.img = R.mipmap.liposuction;

        HomTopTypeBean bean4 = new HomTopTypeBean();
        bean4.id = 4;
        bean4.title = "按模减肥";
        bean4.img = R.mipmap.die_pressing;

        HomTopTypeBean bean5 = new HomTopTypeBean();
        bean5.id = 5;
        bean5.title = "拔罐减肥";
        bean5.img = R.mipmap.cupping;

        HomTopTypeBean bean6 = new HomTopTypeBean();
        bean6.id = 6;
        bean6.title = "光纤减肥";
        bean6.img = R.mipmap.optical_fiber;

        HomTopTypeBean bean7 = new HomTopTypeBean();
        bean7.id = 7;
        bean7.title = "刮痧减肥";
        bean7.img = R.mipmap.scraping;

        HomTopTypeBean bean8 = new HomTopTypeBean();
        bean8.id = 8;
        bean8.title = "食物减肥";
        bean8.img = R.mipmap.food;

        types.add(bean1);
        types.add(bean2);
        types.add(bean3);
        types.add(bean4);
        types.add(bean5);
        types.add(bean6);
        types.add(bean7);
        types.add(bean8);

        adapter.setData(types);
    }
}
