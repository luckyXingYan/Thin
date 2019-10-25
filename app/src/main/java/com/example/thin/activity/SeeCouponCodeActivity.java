package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/25
 * @Desc:
 */
public class SeeCouponCodeActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView {

    public static void open(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, SeeCouponCodeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_see_coupon_code;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("查看券码");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
