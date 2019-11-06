package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/28
 * @Desc:
 */
public class WelcomeJoinActivity extends BaseActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private Button btnEvaluating;

    public static void open(Context context) {
        context.startActivity(new Intent(context, WelcomeJoinActivity.class));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_welcome_join;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        btnEvaluating = getView(R.id.btn_start_evaluating);
        btnEvaluating.setOnClickListener(this);

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
            case R.id.btn_start_evaluating://开始评测
                WelcomeJoinActivity.open(this);
                finish();
                break;
        }
    }
}
