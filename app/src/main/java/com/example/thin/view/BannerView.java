package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.adapter.BannerImgAdapter;
import com.example.thin.adapter.TypeAdapter;
import com.example.thin.util.CardScaleHelper;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/17
 * @Desc:
 */
public class BannerView extends BaseHomeLayout<List<String>> {
    private RecyclerView recyclerView;
    private BannerImgAdapter adapter;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_home_banner, this);
        recyclerView = findViewById(R.id.rv_home_banner);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        adapter = new BannerImgAdapter(getContext());
        recyclerView.setAdapter(adapter);

        //效果1：中间item的左右两边item没有缩小效果
//        new PagerSnapHelper().attachToRecyclerView(recyclerView4);

        //效果2：中间item的左右两边item有缩小效果
        CardScaleHelper cardScaleHelper = new CardScaleHelper();
        cardScaleHelper.setCurrentItemPos(1);//设置item位置
        cardScaleHelper.setScale(0.9f);//将左右两边的Item缩小
        cardScaleHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void setData(List<String> data) {
        adapter.setData(data);
    }

}
