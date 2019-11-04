package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.adapter.SearchAdapter;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.PreferenceUtil;
import com.example.thin.util.SearchStorageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class SearchActivity extends BaseActivity<BasePresenter> implements IBaseView {
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private TextView tvInputSearch;
    private EditText etInputSearch;
    private String inputStr;


    public static void open(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvInputSearch = getView(R.id.tv_input_search);
        tvInputSearch.setVisibility(View.GONE);
        etInputSearch = getView(R.id.et_input_search);
        etInputSearch.setVisibility(View.VISIBLE);
        recyclerView = getView(R.id.rv_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SearchAdapter(this);
        recyclerView.setAdapter(adapter);

        etInputSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //点击搜索的时候隐藏软键盘
//                    hideKeyboard(EditText);
                    // 在这里写搜索的操作,一般都是网络请求数据
                    inputStr = etInputSearch.getText().toString().trim();
                    SearchStorageUtils.saveSearchHistory(inputStr);
                    SearchResultActivity.open(SearchActivity.this, inputStr);
                    finish();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void initData() {
        List<String> data = new ArrayList<>();
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");

        adapter.setData(data);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
