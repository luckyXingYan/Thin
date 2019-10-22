package com.example.thin.activity;

import android.os.Bundle;

import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class HomeTypeActivity extends BaseActivity<BasePresenter> implements IBaseView {
    @Override
    protected int layoutId() {
        return 0;
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
