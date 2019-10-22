package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class CashierActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView {
    public static void open(Context context) {
        context.startActivity(new Intent(context, CashierActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_cashier;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("收银台");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
