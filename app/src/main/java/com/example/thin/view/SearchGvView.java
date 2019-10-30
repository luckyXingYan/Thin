package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.thin.R;
import com.example.thin.adapter.SearchRvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class SearchGvView extends BaseHomeLayout<String> {
    private RecyclerView recyclerView;
    private SearchRvAdapter adapter;

    public SearchGvView(Context context) {
        this(context, null);
    }

    public SearchGvView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_search, this);
        recyclerView = findViewById(R.id.rv_search_gv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new SearchRvAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(String data) {


        List<String> data1 = new ArrayList<>();
        data1.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data1.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data1.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data1.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data1.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");

        adapter.setData(data1);
    }

}
