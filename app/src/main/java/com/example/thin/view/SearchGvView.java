package com.example.thin.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.thin.R;
import com.example.thin.adapter.SearchRvAdapter;
import com.example.thin.util.SearchStorageUtils;

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
    private List<String> historyList;
    private int type;

    public SearchGvView(Context context, int type) {
        this(context, null);
        this.type = type;
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
    public void setData(final String data) {
        if (type == 0) {//最近搜索
            historyList = SearchStorageUtils.getSearchHistory();
        } else if (type == 1) {//热门搜索
            historyList = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                historyList.add("数据" + i);
            }
        }
        adapter.setData(historyList);
    }
}
