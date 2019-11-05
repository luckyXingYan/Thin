package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class CreateAddressActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {

    public static void open(Context context) {
        context.startActivity(new Intent(context, CreateAddressActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_create_address;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("新建收货地址");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}
