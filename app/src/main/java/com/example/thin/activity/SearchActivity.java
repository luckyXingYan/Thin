package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class SearchActivity extends BaseActivity<BasePresenter> implements IBaseView {
    public static void open(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }
    @Override
    protected int layoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
